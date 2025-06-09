(ns hire-gosha.core
  (:require
   [hire-gosha.components.footer :refer [footer]]
   [hire-gosha.components.hero :refer [hero]]
   [hire-gosha.components.project-card :as project-card]
   [hire-gosha.components.projects :refer [projects]]
   [hire-gosha.components.skills :refer [skills]]
   [hire-gosha.components.testimonials :refer [testimonials]]
   [hire-gosha.data :as data]
   [replicant.dom :as d]))

;; Forward declaration
(declare app)

(defn re-render! []
  (when-let [app-element (.getElementById js/document "app")]
    (d/render app-element (app))))

(defn app []
  [:div.relative.isolate.pt-24.pb-32
   (hero)
   (projects (:projects data/site-data))
   (skills (:skills data/site-data))
   (testimonials (:testimonials data/site-data))
   (footer)])

(defn setup-animations! []
  (when-let [bottom-cta (.getElementById js/document "bottom-cta")]
    (let [observer (atom nil)
          callback (fn [entries]
                     (doseq [entry entries]
                       (when (and (.-isIntersecting entry)
                                  (not (.contains (.-classList (.-target entry)) "animate")))
                         (.add (.-classList (.-target entry)) "animate")
                         (.unobserve @observer (.-target entry)))))]
      (reset! observer (js/IntersectionObserver. callback #js {:threshold 0.5}))
      (.observe @observer bottom-cta))))

(defn init []
  (when-let [app-element (.getElementById js/document "app")]
    (d/render app-element (app))
    (setup-animations!)))
