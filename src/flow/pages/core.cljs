(ns flow.pages.core
  (:require
   [flow.subs :as subs]

   [re-frame.core :as rf]))

(defn about-page [content]
  [:p content])

(defn cv-page [content]
  [:p content])

(defn repos-page [content]
  [:p content])
