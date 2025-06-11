(ns hire-gosha.components.projects
  (:require [hire-gosha.components.project-card :as project-card]))

(defn projects [projects]
  (let [sorted-projects (sort-by #(if (:important %) 0 1) projects)]
    [:div.w-full.pb-16
     [:div.carousel.carousel-center.w-full
      (for [project sorted-projects]
        ^{:key (:title project)}
        (project-card/project-card project))]]))
