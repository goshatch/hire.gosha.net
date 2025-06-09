(ns hire-gosha.components.testimonials
  (:require [hire-gosha.components.testimonial :as testimonial]))

(defn split-into-columns "Split collection into roughly equal groups for columns"
  [coll num-columns]
  (let [items-per-column (Math/ceil (/ (count coll) num-columns))]
    (partition-all items-per-column coll)))

;; Stable shuffled testimonials to avoid reshuffling on re-render
(defonce shuffled-testimonials-cache (atom nil))

(defn testimonials [testimonials]
  (let [shuffled-testimonials (or @shuffled-testimonials-cache
                                  (reset! shuffled-testimonials-cache (shuffle testimonials)))
        testimonial-columns (split-into-columns shuffled-testimonials 4)]
    [:div.testimonials.mx-auto.max-w-7xl.px-6.lg:px-8
     [:div.mx-auto.max-w-2xl.text-center
      [:h3.text-4xl.font-semibold.text-primary.mb-4 "Testimonials"]
      [:p.mt-2.text-balance.text-primary "From 100% certified organic human people I have worked with:"]]
     [:div.mx-auto.mt-8.grid.max-w-2xl.grid-cols-1.grid-rows-1.gap-8.text-sm.text-primary.sm:grid-cols-2.xl:mx-0.xl:max-w-none.xl:grid-flow-col.xl:grid-cols-4
      (for [[index column] (map-indexed vector testimonial-columns)]
        ^{:key (str "testimonial-column-" index)}
        [:div.space-y-8
         (for [testimonial column]
           ^{:key (:author testimonial)}
           (testimonial/testimonial testimonial))])]]))
