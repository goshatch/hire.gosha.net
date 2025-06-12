(ns hire-gosha.components.footer
  (:require [hire-gosha.components.social-link :refer [social-link]]
            [hire-gosha.components.contact :refer [contact]]))

(defn footer []
  [:footer.py-8
   (contact)
   [:div.mx-auto.max-w-7xl.px-6.lg:px-8.mt-32
    [:div.border-t.border-gray-500.pt-8
     {:class ["flex" "flex-col" "md:flex-row" "md:justify-between" "gap-8"]}
     [:div
      [:h3.mb-4 "I am very online:"]
      [:div {:class ["flex" "flex-col" "lg:flex-row" "gap-4"]}
       (social-link {:href "https://gosha.net" :emoji "🏴‍☠️" :label "Homepage"})
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
