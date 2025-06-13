(ns hire-gosha.components.hero)

(defn hero []
  [:div.relative.max-w-7xl.mx-auto
   [:div.flex.flex-col.lg:flex-row.lg:items-center.gap-8.lg:gap-12.mb-16
    [:div.flex-shrink-0.profile-photo
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
       [:a.btn.btn-lg.btn-outline.rounded-full.no-underline.font-normal
        {:href "#contact"}
        "More contact options"]]]
     [:p.mt-12
      "It’s nice to meet you!"]
     [:p.mt-4
      "I am a true generalist: I am happiest when I can take ownership of problems and contribute across the entire stack, without being siloed to a specific part of it. Backend, frontend, infra, UI, UX, building and mentoring engineering teams — I have done it all over the course of my career."]
     [:p.mt-4
      "Currently, I am looking to join a company where I could work on hard problems, share what I know, and grow together with the team over the next many years."]
     [:p.mt-4
      "I live in London 🇬🇧 with my partner and soon-to-be-two kids. I can work in both the UK and in the EU, and do not require visa sponsorship."]
     [:p.mt-4
      "Please take a look at my past work and skills below, and reach out if you feel I would we would be a good fit."]
     [:p.mt-4
      [:span.text-sm.font-semibold
       "Current status: "]
      [:div.badge.badge-accent.font-semibold
       [:div {:class ["inline-grid" "*:[grid-area:1/1]"]}
        [:div {:class ["status" "status-success" "animate-ping"]}]
        [:div {:class ["status" "status-success"]}]]
       [:span.color-black.text-sm "Interviewing"]]]]]])
