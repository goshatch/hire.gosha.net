(ns hire-gosha.components.testimonial)

(defn testimonial [{:keys [quote author title url photo]}]
  [:figure.rounded-2xl.bg-surface.p-6.shadow-lg.ring-1
   [:blockquote.text-primary
    [:p quote]]
   [:figcaption.mt-4.flex.gap-x-3
    [:div.avatar
     [:div.w-12.h-12.rounded-full
      [:img
       {:src photo :alt author :loading "lazy"}]]]
    [:div
     [:div.font-semibold.mb-1
      (if url
        [:a {:href url} author]
        author)]
     [:div.text-neutral.text-xs title]]]])
