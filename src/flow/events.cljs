(ns flow.events
  (:require
   [re-frame.core :as rf]))

(rf/reg-event-db
  :initialize
  (fn [_ _]
    {:counter 0
     :title   "Welcome to Re-frame!"}))
