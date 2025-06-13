(ns hire-gosha.components.skills
  (:require [hire-gosha.components.pill :as pill]))

(defn skills [skills]
  [:div.mx-auto.max-w-4xl.px-6.lg:px-8.py-16
   [:div.text-center.mb-8
    [:h2.text-4xl.font-semibold.text-primary.mb-8 "Technologies & Skills"]
    [:div.pills
     (for [skill skills]
       ^{:key (:name skill)}
       (pill/pill skill))]]])
