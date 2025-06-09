(ns hire-gosha.components.social-link)

(defn social-link [{:keys [href emoji label]}]
  [:a
   {:class ["no-underline"
            "flex"
            "items-center"
            "gap-1"
            "hover:text-primary"
            "transition-colors"]
    :href href
    :target "_blank"
    :aria-label label}
   [:span emoji]
   [:span.underline label]])
