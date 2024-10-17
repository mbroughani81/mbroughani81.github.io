(ns flow.routes
  (:require
   [re-frame.core :as rf]
   [reitit.frontend :as rfr]
   [reitit.coercion.spec :as rss]
   [reitit.frontend.easy :as rfe]

   [flow.pages.core :as pages]
   [flow.events :as events]
   ))

(def routes
  ["/"
   [""
    {:name      ::root
     :view      pages/about-page
     :body-file "about.md"}]
   ["about"
    {:name      ::about
     :view      pages/about-page
     :body-file "about.md"}]
   ["cv"
    {:name      ::cv
     :view      pages/cv-page
     :body-file "cv.md"}]
   ["repos"
    {:name      ::repos
     :view      pages/repos-page
     :body-file "repos.md"}]
   ])

(defn on-navigate [new-match]
  (when new-match
    (rf/dispatch [::events/navigate new-match])))

(def router
  (rfr/router
    routes
    {:data {:coercion rss/coercion}}))
(defn init-routes! []
  (rfe/start!
    router
    on-navigate
    {:use-fragment false}))
