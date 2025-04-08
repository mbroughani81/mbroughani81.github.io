(ns flow.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   [clojure.string :as str]
   [re-frame.core :as rf]
   [taoensso.timbre :as timbre]

   [flow.events :as events]
   [flow.subs :as subs]
   [flow.routes :as routes])
  (:require-macros [flow.get-drops :refer [<-drops]]))

;; -------------------------------------------------- ;;
;; -------------------------------------------------- ;;

(defn page []
  (let [drops     (<-drops)
        drops     (mapv #(-> [:p (:body %)]) drops)
        page-body @(rf/subscribe [::subs/page-body])
        _         (timbre/info "db => " @(rf/subscribe [::subs/db]))
        view      @(rf/subscribe [::subs/page-view])
        _         (timbre/info "page-body view" page-body view)
        ;; Why view can be nil?
        page      (when view
                    (view page-body))
        _         (when page
                    (timbre/info "page => " page))]
    (if (nil? page)
      [:div {:class "drops-container"} [:h1 ""]]
      [:div {:class "page-container"} page]
      )))

(defn header []
  [:header
   [:div.header-container
    [:div.header-left "Mohammad Broughani"]
    [:div.header-right
     [:ul
      [:li {:class "header-item"} [:a {:href "/about"} "about"]]
      [:li {:class "header-item"} [:a {:href "https://drive.google.com/file/d/1ivFpiV837uX1g7HoKde2PPAZu-bgA6MH/view"} "cv"]]
      ;; [:li {:class "header-item"} [:a {:href "/repos"} "repos"]]
      ]]]])

(defn app []
  [:div
   [header]
   [page]])

;; -------------------------------------------------- ;;

(defn mount-root []
  (d/render [app] (.getElementById js/document "app")))

(defn ^:export init! []
  (timbre/set-min-level! :warn)
  (rf/clear-subscription-cache!)
  (rf/dispatch-sync [::events/initialize])
  (routes/init-routes!)
  (mount-root))

;; -------------------------------------------------- ;;

(comment
  (flow)
  (simple-example)


  )

;; -------------------------------------------------- ;;
;; -------------------------------------------------- ;;
