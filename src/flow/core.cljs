(ns flow.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   [clojure.string :as str])
  (:require-macros [flow.get-drops :refer [<-drops]]))

;; -------------------------------------------------- ;;
;; -------------------------------------------------- ;;

(defn flow []
  (let [drops      (<-drops)
        drops-comp (mapv #(-> [:p (:body %)]) drops)
        _          (println "GOOsss" drops-comp)]
    (into [] (concat [:div] drops-comp))))


;; -------------------------------------------------- ;;

(defn mount-root []
  (d/render [flow] (.getElementById js/document "app")))

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
