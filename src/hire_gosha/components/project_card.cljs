(ns hire-gosha.components.project-card)

(defn project-card [{:keys [title company year description image link github important]}]
  [:div.carousel-item.ml-4
   [:div.card.w-fit
    [:figure
     [:img {:class ["h-[50vh]"]
            :src image
            :alt title}]]
    [:div.card-body
     [:h4.text-lg.font-semibold.text-primary.mb-1 title]
     [:p.text-sm.text-secondary.mb-2
      company " • " year]
     [:p.text-sm.text-primary.line-clamp-2 description]]]])
