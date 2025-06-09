(ns hire-gosha.components.projects
  (:require [hire-gosha.components.project-card :as project-card]))

(defn projects [projects]
  (let [sorted-projects (sort-by #(if (:important %) 0 1) projects)]
    [:div.w-full.py-16
     [:div.mx-auto.max-w-2xl.text-center.mb-12.px-6.lg:px-8
      [:h3.text-4xl.font-semibold.text-primary.mb-4 "Featured Projects"]
      [:p.mt-2.text-balance.text-primary "Some highlights from my recent work—"]]
     [:div.grid.grid-cols-1.md:grid-cols-2.lg:grid-cols-3.gap-8.px-6.lg:px-8
      (for [project sorted-projects]
        ^{:key (:title project)}
        (project-card/project-card project))]]))