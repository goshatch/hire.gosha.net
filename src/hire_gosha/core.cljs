(ns hire-gosha.core
  (:require [replicant.dom :as d]
            [hire-gosha.data :as data]
            [clojure.string :as str]))

(defn pill-component [{:keys [name icon]}]
  [:span.pill
   [:span.pill-icon icon]
   name])

(defn testimonial-component [{:keys [quote author title url photo]}]
  [:figure.rounded-2xl.bg-surface.p-6.shadow-lg.ring-1
   [:blockquote.text-primary
    [:p quote]]
   [:figcaption.mt-6.flex.gap-x-4
    [:img.size-10.mt-1.rounded-full.bg-surface
     {:src photo :alt author}]
    [:div
     [:div.font-semibold
      (if url
        [:a {:href url} author]
        author)]
     [:div.text-secondary title]]]])

;; Global state for image carousel indices
(defonce project-carousel-states (atom {}))

;; Forward declaration
(declare app)

(defn re-render! []
  (when-let [app-element (.getElementById js/document "app")]
    (d/render app-element (app))))

(defn project-card-component [{:keys [title company year description images link github important]}]
  (let [project-id (str title "-" company)
        total-images (count images)
        current-index (get @project-carousel-states project-id 0)
        next-image! (fn []
                      (swap! project-carousel-states assoc project-id (mod (inc current-index) total-images))
                      (re-render!))
        prev-image! (fn []
                      (swap! project-carousel-states assoc project-id (mod (dec current-index) total-images))
                      (re-render!))]
    
    [:div.bg-surface.rounded-2xl.shadow-lg.ring-1.overflow-hidden
     {:class (when important ["ring-2" "ring-primary"])}
     
     ;; Image carousel (full-width, no padding)
     [:div.relative
      [:div.aspect-video.bg-gray-100.relative
       [:img.w-full.h-full.object-cover
        {:src (nth images current-index)
         :alt (str title " - Image " (inc current-index))}]
       
       ;; Navigation buttons (only show if multiple images)
       (when (> total-images 1)
         [:div
          [:button.absolute.left-2.bg-black.text-white.rounded-full.w-8.h-8.flex.items-center.justify-center
           {:class ["top-1/2" "transform" "-translate-y-1/2" "bg-opacity-50" "hover:bg-opacity-75"]
            :on {:click prev-image!}}
           "‹"]
          [:button.absolute.right-2.bg-black.text-white.rounded-full.w-8.h-8.flex.items-center.justify-center
           {:class ["top-1/2" "transform" "-translate-y-1/2" "bg-opacity-50" "hover:bg-opacity-75"]
            :on {:click next-image!}}
           "›"]])
       
       ;; Image indicators
       (when (> total-images 1)
         [:div.absolute.bottom-2.flex.gap-1
          {:class ["left-1/2" "transform" "-translate-x-1/2"]}
          (for [i (range total-images)]
            ^{:key i}
            [:div.w-2.h-2.rounded-full
             {:class (if (= i current-index) ["bg-primary"] ["bg-gray-100" "bg-opacity-75"])}])])]]
     
     ;; Project info (with padding)
     [:div.p-6
      [:div.flex.justify-between.items-start.mb-2
       [:h4.text-xl.font-semibold.text-primary title]
       (when important
         [:span.bg-primary.text-surface.text-xs.px-2.py-1.rounded-full "Featured"])]
      [:div.flex.text-sm.text-secondary.mb-3
       [:span company]
       [:span.mx-2 "•"]
       [:span year]]
      [:p.text-primary.mb-4 description]
      
      ;; Links
      [:div.flex.gap-3
       (when link
         [:a.btn.btn-sm.px-4.py-2.rounded-lg.text-sm
          {:href link :target "_blank"}
          "View Project"])
       (when github
         [:a.text-secondary.text-sm.underline
          {:href github :target "_blank" :class ["hover:text-primary"]}
          "GitHub"])]]]))

(defn hero-section []
  [:div.relative
   [:div.flex.flex-col.lg:flex-row.lg:items-center.gap-8.lg:gap-12.mb-16
    [:div.flex-shrink-0
     [:img.w-120.h-80.lg:w-144.lg:h-96.rounded-sm.shadow-2xl.border-8.border-white.transform.-rotate-3.object-cover
      {:src "/images/profile.jpg" :alt "Gosha Tcherednitchenko"}]]
    [:div.flex-1.px-6.lg:px-8
     [:h1.text-5xl.font-bold.text-primary.leading-tight
      "Hi, I'm " [:a.underline {:href "https://gosha.net"} "Gosha"] " 👋"]
     [:p.text-4xl.font-bold.leading-tight.mt-4 
      "Full-stack, 20 years of experience, looking for work!"]
     [:a.btn.btn-pop.rounded-full.mt-6.px-6.py-3
      {:href "https://cal.com/a.possible.space/30min"}
      "👉 Let's talk"]]]])

(defn skills-section [{:keys [skills]}]
  [:div.mx-auto.max-w-4xl.px-6.lg:px-8.py-16
   [:div.text-center.mb-8
    [:h3.text-4xl.font-semibold.text-primary.mb-8 "Technologies & Skills"]
    [:div.pills
     (for [skill skills]
       ^{:key (:name skill)}
       (pill-component skill))]]])

(defn split-into-columns "Split collection into roughly equal groups for columns"
  [coll num-columns]
  (let [items-per-column (Math/ceil (/ (count coll) num-columns))]
    (partition-all items-per-column coll)))

;; Stable shuffled testimonials to avoid reshuffling on re-render
(defonce shuffled-testimonials-cache (atom nil))

(defn testimonials-section [{:keys [testimonials]}]
  (let [shuffled-testimonials (or @shuffled-testimonials-cache 
                                  (reset! shuffled-testimonials-cache (shuffle testimonials)))
        testimonial-columns (split-into-columns shuffled-testimonials 4)]
    [:div.testimonials.mx-auto.max-w-7xl.px-6.lg:px-8
     [:div.mx-auto.max-w-2xl.text-center
      [:h3.text-4xl.font-semibold.text-primary.mb-4 "Testimonials"]
      [:p.mt-2.text-balance.text-primary "What people I have worked with have to say—"]]
     [:div.mx-auto.mt-8.grid.max-w-2xl.grid-cols-1.grid-rows-1.gap-8.text-sm.text-primary.sm:grid-cols-2.xl:mx-0.xl:max-w-none.xl:grid-flow-col.xl:grid-cols-4
      (for [[index column] (map-indexed vector testimonial-columns)]
        ^{:key (str "testimonial-column-" index)}
        [:div.space-y-8
         (for [testimonial column]
           ^{:key (:author testimonial)}
           (testimonial-component testimonial))])]
     [:div.mt-20.text-center
      [:a.btn.btn-bounce.px-12.py-6.text-2xl.font-bold.rounded-full.shadow-lg
       {:href "https://cal.com/a.possible.space/30min" :id "bottom-cta"}
       "🤙 Book a 30-min call"]]]))

(defn projects-section [{:keys [projects]}]
  (let [sorted-projects (sort-by #(if (:important %) 0 1) projects)]
    [:div.mx-auto.max-w-7xl.px-6.lg:px-8.py-16
     [:div.mx-auto.max-w-2xl.text-center.mb-12
      [:h3.text-4xl.font-semibold.text-primary.mb-4 "Featured Projects"]
      [:p.mt-2.text-balance.text-primary "Some highlights from my recent work—"]]
     [:div.grid.grid-cols-1.md:grid-cols-2.lg:grid-cols-3.gap-8
      (for [project sorted-projects]
        ^{:key (:title project)}
        (project-card-component project))]]))

(defn app []
  [:div.relative.isolate.pt-24.pb-32
   (hero-section)
   (skills-section data/site-data)
   (projects-section data/site-data)
   (testimonials-section data/site-data)])

(defn setup-animations! []
  (when-let [bottom-cta (.getElementById js/document "bottom-cta")]
    (let [observer (atom nil)
          callback (fn [entries]
                     (doseq [entry entries]
                       (when (and (.-isIntersecting entry)
                                  (not (.contains (.-classList (.-target entry)) "animate")))
                         (.add (.-classList (.-target entry)) "animate")
                         (.unobserve @observer (.-target entry)))))]
      (reset! observer (js/IntersectionObserver. callback #js {:threshold 0.5}))
      (.observe @observer bottom-cta))))

(defn init []
  (when-let [app-element (.getElementById js/document "app")]
    (d/render app-element (app))
    (setup-animations!)))
