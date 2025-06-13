(ns hire-gosha.data)

(def site-data
  {:skills
   [{:name "Clojure" :icon "🧬"}
    {:name "ClojureScript" :icon "🕸️"}
    {:name "Ruby" :icon "💎"}
    {:name "Ruby on Rails" :icon "🚂"}
    {:name "React" :icon "⚛️"}
    {:name "TypeScript" :icon "📘"}
    {:name "Lisp" :icon "🛸"}
    {:name "Leadership" :icon "👥"}
    {:name "Mentoring" :icon "🎯"}
    {:name "AI Workflows" :icon "🤖"}
    {:name "CI/CD" :icon "🔄"}
    {:name "TDD" :icon "🧪"}
    {:name "Observability" :icon "👁️"}
    {:name "Alerting" :icon "🚨"}
    {:name "Data Wrangling" :icon "📊"}
    {:name "REST APIs" :icon "🔗"}
    {:name "Custom SDKs" :icon "🛠️"}
    {:name "Async Communication" :icon "💬"}
    {:name "Long-form Writing" :icon "✍️"}]

   :projects
   [{:title "Parts: a toolkit for IFS practitioners"
     :company "A Possible Space"
     :company-link "https://a.possible.space"
     :year "2024-2025"
     :description "A mapping tool built for Internal Family Systems therapists and their clients. Clojure backend, ClojureScript frontend, highly interactive canvas UI, with multiplayer collaboration in the works."
     :image "/images/projects/parts.jpg"
     :link "https://parts.ifs.tools"
     :gh-username "apossiblespace"
     :gh-repo "parts"}

    {:title "Internal tooling during massive growth"
     :company "Indeed Flex"
     :company-link "https://www.indeedflex.co.uk"
     :year "2021-2025"
     :description "Full-stack enablement work, with a focus on observability/monitoring. Led frontend migration to a microfrontend architecture, introduced org-wide contract testing, and mentored junior engineers."
     :image "/images/projects/flex.jpg"}

    {:title "Natural Sitter: a pet sitting marketplace"
     :company "株式会社るりら"
     :year "2020-2021"
     :description "Solo dev on a full-featured pet sitting marketplace: progressively enhanced HTML, full I18n, automated CI/CD, and near-total test coverage."
     :image "/images/projects/naturalsitter.jpg"}

    {:title "Mobile Web level up"
     :company "Moneytree"
     :company-link "https://getmoneytree.com"
     :year "2016-2017"
     :description "Helped transition the mobile web app from Angular to React, which included some prety gnarly hacks like running a React application inside an Angular shell, all in the name of keeping features shipping."
     :image "/images/projects/moneytree.jpg"}

    {:title "Designing an engineering organisation"
     :company "AQ"
     :company-link "https://aqworks.com"
     :year "2013-2016"
     :description "Designed engineering systems, processes, and playbooks for a new technical organisation within AQ's established product design business. Clients included Google, Asics, Medium, Airbnb, etc."
     :image "/images/projects/aq.jpg"}

    {:title "Pioneering mobile Web"
     :company "Cookpad Japan"
     :company-link "https://cookpad.jp"
     :year "2011-2013"
     :description "Launched the mobile web version of one of Japan's highest-traffic sites at the start of the smartphone era. Heavy emphasis on performance and bandwidth efficiency. Serving millions monthly."
     :image "/images/projects/cookpad.jpg"}]

   :testimonials
   [{:quote "I've shipped many products with Gosha over the x years we worked together. He's a versatile full stack developer with a knack for design—a solid tech partner for any challenge."
     :author "Tomomi Sasaki"
     :title "Partner at design studio AQ"
     :url "https://aqworks.com"
     :photo "/images/people/tomomi.jpg"}

    {:quote "I've worked with Gosha on many projects over the years. Not only is he an excellent developer and expert in his craft, but he's also a true \"maker\", deeply curious and engaged in every aspect of product development. He brings the same level of attention to both the technical implementation and the user experience. As a designer, that quality makes him easily one of my favorite software developers to work with."
     :author "Mathieu Mayer"
     :title "Designer & Developer"
     :url "https://mx3m.xyz"
     :photo "/images/people/mathieu.jpg"}

    {:quote "Working with Gosha on strategic projects for regional banking clients in Japan, he consistently championed user experience, always finding ways to make the product UX that extra 1% better despite tight deadlines."
     :author "Jonathon Toon"
     :title "Design Leader"
     :url "https://jonathontoon.com"
     :photo "/images/people/jonathon.jpg"}

    {:quote "I worked as an engineer with Gosha. I have learned so much through our time building things together. He’s a curious, smart and well rounded engineer. On top of this, he is a funny and kind person. I would love to crack problems with him again any time I have the opportunity."
     :author "Marion Kamoike-Bouguet"
     :title "Senior Engineering Manager at Strapi"
     :url "https://www.linkedin.com/in/m-kb/"
     :photo "/images/people/marion.jpg"}

    {:quote "Gosha is a talented full-stack engineer with a knack for delivering intuitive user experiences. He cares about outcomes, delivers high quality work, and is a great addition to any startup or established engineering team."
     :author "Charles Abbott"
     :title "Senior Director, Engineering at Workiva"
     :url "https://www.workiva.com/"
     :photo "/images/people/charles.jpg"}

    {:quote "Gosha is a smart, adept, and highly autonomous full-stack developer. He delivers quickly, maintains high quality, and consistently drives the product forward with clarity and focus."
     :author "Raj Gurung"
     :title "Senior Software Engineer at Indeed"
     :url "https://www.linkedin.com/in/raj-gurung-06235862/"
     :photo "/images/people/raj.jpg"}

    {:quote "Working with Gosha was like having a strategic co-founder who also writes exceptional code. He quickly grasped the business goals, translated them into clean, scalable architecture, and kept me informed of potential risks long before they became issues. His mix of business acumen and full-stack expertise made our launch smooth and our growth trajectory clear. I recommend him without reservation."
     :author "Nahoko Tateyama"
     :title "Business Tech Director at SquareTrade"
     :url "https://www.linkedin.com/in/nahoko-tateyama/"
     :photo "/images/people/nahoko.jpg"}

    {:quote "Gosha brought a strong mix of front-end engineering and design skills when we worked together at Cookpad. He helped build out the mobile web version with solid work in Ruby, JavaScript, and CSS, and his ability to move between design and code made things smoother for the whole team."
     :author "Viktor Kelemen"
     :url "https://www.linkedin.com/in/viktorkelemen/"
     :title "Software Engineer at Meta"
     :photo "/images/people/viktor.jpg"}

    {:quote "When full-stack also means full empathy! Gosha brings sharp engineering skills with a rare eye for UI and UX."
     :author "Paul Baron"
     :title "Product"
     :url "https://aka.me"
     :photo "/images/people/paul.jpg"}

    {:quote "Over the past five years, I’ve had the luck of working with Gosha both directly—as part of the same cross-functional team—and indirectly as part of the same larger engineering organisation.

In every instance, Gosha has been a helpful, collaborative, and fun team player. He brought strong value to both the backend and frontend codebase of our applications.

Additionally G’s background and interest in (web)design was radiant in his thoughtful approach to building and suggesting user-centered solutions, always with accessibility in mind.

He’s a reliable contributor, pleasure to work with as a colleague, and I highly recommend him as a teammate."
     :author "Marek Labos"
     :title "Senior Software Engineer at Indeed"
     :url "https://www.linkedin.com/in/marek-labos"
     :photo "/images/people/marek.jpg"}]})
