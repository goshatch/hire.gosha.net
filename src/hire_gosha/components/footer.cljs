(ns hire-gosha.components.footer
  (:require [hire-gosha.components.social-link :refer [social-link]]))

(defn footer []
  [:footer.py-8
   [:div.mt-20.text-center
    [:p.mb-6 "Do you feel I would be a good fit for your project? Let's talk."]
    [:a.btn.btn-xl.btn-primary.btn-bounce.rounded-full.shadow-lg.no-underline
     {:href "https://cal.com/a.possible.space/30min" :id "bottom-cta"}
     "🤙 Book a 30-min call"]]

   [:div.mx-auto.max-w-7xl.px-6.lg:px-8.mt-32
    [:div.border-t.border-gray-500.pt-8
     {:class ["flex" "flex-col" "md:flex-row" "md:justify-between" "gap-8"]}
     [:div
      [:h3.mb-4 "I am unfortunately very online:"]
      [:div {:class ["flex" "flex-col" "lg:flex-row" "gap-4"]}
       (social-link {:href "https://gosha.net" :emoji "🏴‍☠️" :label "Online Homepage"})
       (social-link {:href "https://linkedin.com/in/goshatch" :emoji "💼" :label "LinkedIn"})
       (social-link {:href "https://github.com/goshatch" :emoji "🐙" :label "GitHub"})
       (social-link {:href "https://merveilles.town/@gosha" :emoji "🐘" :label "Mastodon"})
       (social-link {:href "https://twitter.com/goshatch" :emoji "🐦" :label "Twitter"})
       (social-link {:href "https://bsky.app/profile/gosha.net" :emoji "🦋" :label "Bluesky"})]]
     [:div.flex-shrink-0
      [:h3.mb-4 "About this page"]
      [:p
       "Built with "
       [:a {:href "https://clojurescript.org"} "ClojureScript"]
       ", "
       [:a {:href "https://replicant.fun"} "Replicant"]
       ", "
       [:a {:href "https://daisyui.com"} "daisyUI"]
       ", and "
       [:a {:href "https://tailwindcss.com"} "Tailwind CSS"]
       "."]
      [:p.mt-2
       "Source code available "
       [:a {:href "https://github.com/goshatch/hire.gosha.net"} "on GitHub"]
       "."]]]]])
