(ns hire-gosha.components.project-card)

(defn project-card [{:keys [title company company-link year description image link gh-username gh-repo]}]
  (let [image [:img {:class ["h-[50vh]"]
                     :src image
                     :alt title
                     :loading "lazy"}]]
    [:div.carousel-item
     [:div.card.w-fit
      [:figure
       (if link
         [:a {:href link :target "_blank"} image]
         image)]
      [:div.card-body
       [:h4.text-lg.font-semibold.text-primary.mb-1
        (if link
          [:a {:href link :target "_blank"} title]
          title)]
       [:p.text-sm.text-secondary.mb-2
        (if company-link
          [:a {:href company-link :target "_blank"} company]
          company) " / " year]
       [:p.text-sm.text-primary description]
       (when (and gh-username gh-repo)
         [:a {:href (str "https://github.com/" gh-username "/" gh-repo) :target "_blank"}
          [:img {:src (str "https://img.shields.io/github/stars/" gh-username "/" gh-repo)
                 :loading "lazy"}]])]]]))
