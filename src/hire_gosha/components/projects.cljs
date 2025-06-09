(ns hire-gosha.components.projects
  (:require [hire-gosha.components.project-card :as project-card]))

(defn projects [projects]
  (let [sorted-projects (sort-by #(if (:important %) 0 1) projects)]
    [:div.w-full.py-16
     [:div.mx-auto.max-w-2xl.text-center.mb-12.px-6.lg:px-8
      [:h3.text-4xl.font-semibold.text-primary.mb-4 "Featured Projects"]
      [:p.mt-2.text-balance.text-primary "Some highlights from my recent work—"]]
     
     ;; Full-width horizontal scrolling container
     [:div.w-full.overflow-x-auto.scrollbar-hide
      [:div.flex.gap-6.px-6.lg:px-8.pb-4
       (for [project sorted-projects]
         ^{:key (:title project)}
         (project-card/project-card project))
       
       ;; Spacer at the end
       [:div.flex-shrink-0.w-6]]]]))