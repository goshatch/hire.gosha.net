(ns hire-gosha.components.testimonial)

(defn testimonial [{:keys [quote author title url photo]}]
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