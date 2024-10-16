(ns flow.events
  (:require
   [re-frame.core :as rf])
  (:require-macros [flow.get-drops :refer [<-pages]]))

(rf/reg-event-db
  ::initialize
  (fn [_ _]
    {:counter 0
     :title   "Welcome to Re-frame!"
     :pages   (<-pages)}))

(rf/reg-event-db
  ::navigate
  (fn [db [_ new-match]]
    (let [match (-> new-match :data)]
      (println "current-match => " match)
      (-> db
          (assoc :current-match match)))))

(comment

  (def zz :flow.routes/about)


  (println ::rf/gooz)


  )
