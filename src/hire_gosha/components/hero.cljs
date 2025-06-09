(ns hire-gosha.components.hero)

(defn hero []
  [:div.relative
   [:div.flex.flex-col.lg:flex-row.lg:items-center.gap-8.lg:gap-12.mb-16
    [:div.flex-shrink-0
     [:img.w-120.h-80.lg:w-144.lg:h-96.rounded-sm.shadow-2xl.border-8.border-white.transform.-rotate-3.object-cover
      {:src "/images/profile.jpg" :alt "Gosha Tcherednitchenko"}]]
    [:div.flex-1.px-6.lg:px-8
     [:h1.text-5xl.font-bold.text-primary.leading-tight
      "Hi, I'm " [:a.underline {:href "https://gosha.net"} "Gosha"] " 👋"]
     [:p.text-4xl.font-bold.leading-tight.mt-4
      "Full-stack, 20 years of experience, looking for work!"]
     [:div.flex.flex-col.md:flex-row.gap-4.mt-6
      [:div
      [:a.btn.btn-pop.rounded-full.px-6.py-3
       {:href "https://cal.com/a.possible.space/30min"}
       "👉 Let's talk!"]]
      [:div
      [:a.btn.outline.rounded-full.px-6.py-3
       {:href "https://linkedin.com/in/goshatch" :target "_blank"}
       "💼 Connect on LinkedIn"]]]]]])
