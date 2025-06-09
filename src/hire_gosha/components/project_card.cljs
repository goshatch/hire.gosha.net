(ns hire-gosha.components.project-card
  (:require [replicant.dom :as d]))

;; Global state for image carousel indices
(defonce project-carousel-states (atom {}))

;; Forward declaration for re-render function
(declare re-render!)

(defn project-card [{:keys [title company year description images link github important]}]
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

;; This will be set by the main app
(defn set-re-render-fn! [fn]
  (def re-render! fn))