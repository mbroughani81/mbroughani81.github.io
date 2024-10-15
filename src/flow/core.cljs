(ns flow.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   [clojure.string :as str]
   [re-frame.core :as rf]

   [flow.events :as events]
   [flow.subs :as subs])
  (:require-macros [flow.get-drops :refer [<-drops]]))

;; -------------------------------------------------- ;;
;; -------------------------------------------------- ;;

(defn flow []
  (let [drops (<-drops)
        drops (mapv #(-> [:p (:body %)]) drops)
        _     (println "Here is the " @(rf/subscribe [::subs/page-body]))
        ]
    (into [] (concat [:div {:class "drops-container"}] drops))))

(defn header []
  [:header
   [:ul
    [:li {:class "header-item"} "Flow"]
    [:li {:class "header-item"} "Menu"]
    [:li {:class "header-item"} "Menu"]
    [:li {:class "header-item"} "Menu"]
    [:li {:class "header-item"} "Menu"]
    ]])

(defn page []
  [:div
   [header]
   [flow]])

;; -------------------------------------------------- ;;

(defn mount-root []
  (d/render [page] (.getElementById js/document "app")))

(defn ^:export init! []
  (rf/dispatch-sync [::events/initialize])
  (mount-root))

;; -------------------------------------------------- ;;

(comment
  (flow)
  (println "GGG")
  (simple-example)

  (<-drops)

  )

;; -------------------------------------------------- ;;
;; -------------------------------------------------- ;;
