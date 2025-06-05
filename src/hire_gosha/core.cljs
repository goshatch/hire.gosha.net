(ns hire-gosha.core
  (:require [replicant.dom :as d]
            [hire-gosha.data :as data]))

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

(defn testimonials-section [{:keys [testimonials]}]
  (let [shuffled-testimonials (shuffle testimonials)
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

(defn app []
  [:div.relative.isolate.pt-24.pb-32
   (hero-section)
   (skills-section data/site-data)
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
