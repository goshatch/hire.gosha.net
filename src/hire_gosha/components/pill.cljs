(ns hire-gosha.components.pill)

(defn pill [{:keys [name icon]}]
  [:span.pill
   [:span.pill-icon icon]
   name])