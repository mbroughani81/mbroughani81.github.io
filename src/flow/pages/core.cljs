(ns flow.pages.core
  (:require
   [flow.subs :as subs]

   [re-frame.core :as rf]))

(defn about-page [content]
  [:p content])
