(ns hire-gosha.components.contact)

(defn contact []
  [:section#contact
   {:class ["mt-20" "text-center" "mx-auto" "max-w-xl" "px-6" "lg:px-8"]}
   [:p.mb-6 "Do you feel I would be a good fit for your project? Let's talk."]
   [:a.mb-4.btn.btn-block.btn-lg.btn-primary.btn-bounce.rounded-full.shadow-lg.no-underline
    {:href "https://cal.com/a.possible.space/30min" :id "bottom-cta"}
    "🤙 Book a 30-min call"]
   [:a
    {:class "btn mb-4 btn-block btn-lg rounded-full no-underline"
     :href "mailto:gosha@gosha.net"}
    "💌 Email"]
   [:a
    {:class "btn mb-4 btn-block btn-lg rounded-full no-underline"
     :href "/assets/gosha-tcherednitchenko-2025.pdf"}
    "📄 Download CV"]
   [:a
    {:href "https://linkedin.com/in/goshatch"
     :target "_blank"
     :class "btn btn-block btn-lg rounded-full bg-[#0967C2] text-white border-[#0059b3] no-underline"}
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
    "Connect on LinkedIn"]])
