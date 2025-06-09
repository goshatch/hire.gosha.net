(ns hire-gosha.components.project-card)

(defn project-card [{:keys [title company year description images link github important]}]
  [:div.inline-block
   ;; Single image - natural inline behavior with height constraint
   [:img.rounded-lg.mb-4
    {:class ["h-[40vh]" "md:h-[50vh]"]
     :src (first images)
     :alt title}]
   
   ;; Short description underneath - matches image width
   [:div
    [:h4.text-lg.font-semibold.text-primary.mb-1 title]
    [:p.text-sm.text-secondary.mb-2
     company " • " year]
    [:p.text-sm.text-primary.line-clamp-2 description]
    
    ;; Links
    (when (or link github)
      [:div.flex.gap-2.mt-3
       (when link
         [:a.text-xs.text-secondary.hover:text-primary.underline
          {:href link :target "_blank"}
          "View →"])
       (when github
         [:a.text-xs.text-secondary.hover:text-primary.underline
          {:href github :target "_blank"}
          "Code →"])])]])