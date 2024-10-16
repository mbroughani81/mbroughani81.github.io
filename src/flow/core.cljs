(ns flow.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   [clojure.string :as str]
   [re-frame.core :as rf]

   [flow.events :as events]
   [flow.subs :as subs]
   [flow.routes :as routes])
  (:require-macros [flow.get-drops :refer [<-drops]]))

;; -------------------------------------------------- ;;
;; -------------------------------------------------- ;;

(defn flow []
  (let [drops     (<-drops)
        drops     (mapv #(-> [:p (:body %)]) drops)
        page-body @(rf/subscribe [::subs/page-body])
        _         (println "db => " @(rf/subscribe [::subs/db]))
        view      @(rf/subscribe [::subs/page-view])
        ;; Why view can be nil?
        _         (println "VV => " (type view) page-body)
        page      (when view
                    (view page-body))
        _         (when page
                    (println "PPPP => " page))
        ]
    ;; (into [] (concat [:div {:class "drops-container"}] drops))
    (if (nil? page)
      (into [] (concat [:div {:class "drops-container"}] drops))
      [:div {:class "drops-container"} page]
      )))

(defn header []
  [:header
   [:ul
    [:li {:class "header-item"} [:a {:href "/about"} "about"]]
    [:li {:class "header-item"} [:a {:href "/cv"} "cv"]]
    [:li {:class "header-item"} [:a {:href "/cy"} "cy"]]
    [:li {:class "header-item"} [:a {:href "/cz"} "cz"]]
    ]])

(defn page []
  [:div
   [header]
   [flow]])

;; -------------------------------------------------- ;;

(defn mount-root []
  (d/render [page] (.getElementById js/document "app")))

(defn ^:export init! []
  (rf/clear-subscription-cache!)
  (rf/dispatch-sync [::events/initialize])
  (routes/init-routes!)
  (mount-root))

;; -------------------------------------------------- ;;

(comment
  (flow)
  (println "GGG")
  (simple-example)


  )

;; -------------------------------------------------- ;;
;; -------------------------------------------------- ;;
