(ns flow.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   [clojure.string :as str])
  (:require-macros [flow.get-drops :refer [<-drops]]))

;; -------------------------------------------------- ;;
;; -------------------------------------------------- ;;

(defn flow []
  (let [drops (<-drops)
        drops (mapv #(-> [:p (:body %)]) drops)
        _     (println "GOOsss" drops)]
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
  (mount-root ))

;; -------------------------------------------------- ;;

(comment
  (flow)
  (simple-example)

  (<-drops)

  )

;; -------------------------------------------------- ;;
;; -------------------------------------------------- ;;
