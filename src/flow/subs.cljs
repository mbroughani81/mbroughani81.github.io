(ns flow.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
  ::page-body
  (fn [db]
    (let [body-file (-> db :current-match :body-file)
          result    (-> db
                        :pages
                        (get (keyword body-file)))]
      (-> result))))

(rf/reg-sub
  ::page-view
  (fn [db]
    (let [page-view (-> db :current-match :view)]
      (-> page-view))))

(rf/reg-sub
  ::db
  (fn [db _]
    db))
