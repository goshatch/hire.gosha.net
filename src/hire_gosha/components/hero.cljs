(ns hire-gosha.components.hero)

(defn hero []
  [:div.relative
   [:div.flex.flex-col.lg:flex-row.lg:items-center.gap-8.lg:gap-12.mb-16
    [:div.flex-shrink-0
     [:img.w-120.h-80.lg:w-144.lg:h-96.rounded-sm.shadow-2xl.border-8.border-white.transform.-rotate-3.object-cover
      {:src "/images/profile.jpg" :alt "Gosha Tcherednitchenko"}]]
    [:div.flex-1.px-6.lg:px-8
     [:h1.text-5xl.font-bold.text-primary.leading-tight
      "Hi, I’m " [:a.underline {:href "https://gosha.net"} "Gosha"] " 👋"]
     [:p.text-4xl.font-bold.leading-tight.mt-4
      "Full-stack, 20 years of experience, looking for work!"]
     [:div.flex.flex-col.md:flex-row.gap-4.mt-6
      [:div
       [:a.btn.btn-lg.btn-primary.btn-pop.rounded-full.no-underline
        {:href "https://cal.com/a.possible.space/30min"}
        "👉 Book a 30-min call"]]
      [:div
       [:a
        {:href "https://linkedin.com/in/goshatch"
         :target "_blank"
         :class "btn btn-lg rounded-full bg-[#0967C2] text-white border-[#0059b3] no-underline"}
        [:svg
         {:aria-label "LinkedIn logo",
          :width "16",
          :height "16",
          :xmlns "http://www.w3.org/2000/svg",
          :viewBox "0 0 32 32"}
         [:path
          {:fill "white",
           :d
           "M26.111,3H5.889c-1.595,0-2.889,1.293-2.889,2.889V26.111c0,1.595,1.293,2.889,2.889,2.889H26.111c1.595,0,2.889-1.293,2.889-2.889V5.889c0-1.595-1.293-2.889-2.889-2.889ZM10.861,25.389h-3.877V12.87h3.877v12.519Zm-1.957-14.158c-1.267,0-2.293-1.034-2.293-2.31s1.026-2.31,2.293-2.31,2.292,1.034,2.292,2.31-1.026,2.31-2.292,2.31Zm16.485,14.158h-3.858v-6.571c0-1.802-.685-2.809-2.111-2.809-1.551,0-2.362,1.048-2.362,2.809v6.571h-3.718V12.87h3.718v1.686s1.118-2.069,3.775-2.069,4.556,1.621,4.556,4.975v7.926Z",
           :fill-rule "evenodd"}]]
        "Connect on LinkedIn"]]]
     [:p.mt-16
      "It’s nice to meet you! I am a true generalist: I am happiest when I can take ownership of problems and contribute across the entire stack, without being siloed to a specific part of it. Backend, frontend, infra, UI, UX, building and mentoring engineering teams — I have done it all over the course of my career."]
     [:p.mt-4
      "Currently, I am looking to join a company where I could work on hard problems, share what I know, and grow together with the team over the next many years."]
     [:p.mt-4
      "Please take a look at my past work and skills below, and reach out if you feel I would we would be a good fit."]
     [:p.mt-4
      "Current status: "
      [:div.badge.badge-warning.badge-soft.font-semibold
       [:div {:class ["inline-grid" "*:[grid-area:1/1]"]}
        [:div {:class ["status" "status-warning" "animate-ping"]}]
        [:div {:class ["status" "status-warning"]}]]
       [:span.color-black "Interviewing"]]]]]])
