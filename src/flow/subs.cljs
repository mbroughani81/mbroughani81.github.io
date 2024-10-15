(ns flow.subs
  (:require
   [re-frame.core :as rf])
  (:require-macros [flow.get-drops :refer [<-pages]]))

(rf/reg-sub
  ::page-body
  (fn [db [_] page]
    ;; (get-in db [:page-body page])
    ;; (-> "THIS IS PAGE BODY")
    (-> (<-pages))
    ;; This should read the "page" from resources
    ))
