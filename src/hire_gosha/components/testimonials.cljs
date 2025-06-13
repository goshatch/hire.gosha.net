(ns hire-gosha.components.testimonials
  (:require [hire-gosha.components.testimonial :refer [testimonial]]))

(defn split-into-columns "Split collection into exactly num-columns columns, prioritizing middle columns for extra items"
  [coll num-columns]
  (let [total-items (count coll)
        base-items-per-column (quot total-items num-columns)
        extra-items (rem total-items num-columns)
        ;; For 4 columns with 1 extra: middle columns are 1,2 (0-indexed)
        ;; For 4 columns with 2 extra: middle columns are 1,2 (0-indexed)
        middle-cols (case num-columns
                      4 [1 2 0 3] ; priority order: middle first, then outer
                      [0 1 2 3])] ; fallback for other column counts
    (loop [remaining coll
           columns []
           col-index 0]
      (if (or (empty? remaining) (>= col-index num-columns))
        columns
        (let [priority-rank (.indexOf middle-cols col-index)
              gets-extra? (< priority-rank extra-items)
              items-in-this-column (+ base-items-per-column
                                      (if gets-extra? 1 0))
              column (take items-in-this-column remaining)
              new-remaining (drop items-in-this-column remaining)]
          (recur new-remaining
                 (conj columns column)
                 (inc col-index)))))))

(defn testimonials [testimonials]
  (let [testimonial-columns (split-into-columns testimonials 4)]
    [:div.testimonials.mx-auto.max-w-7xl.px-6.lg:px-8
     [:div.mx-auto.max-w-2xl.text-center
      [:h2.text-4xl.font-semibold.text-primary.mb-4 "Testimonials"]
      [:p.mt-2.text-balance.text-primary "From 100% certified organic human people I have worked with:"]]
     [:div.mx-auto.mt-8.grid.max-w-2xl.grid-cols-1.grid-rows-1.gap-8.text-sm.text-primary.sm:grid-cols-2.xl:mx-0.xl:max-w-none.xl:grid-flow-col.xl:grid-cols-4
      (for [[index column] (map-indexed vector testimonial-columns)]
        ^{:key (str "testimonial-column-" index)}
        [:div.space-y-8
         (for [item column]
           ^{:key (:author item)}
           (testimonial item))])]]))
