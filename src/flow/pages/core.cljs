(ns flow.pages.core
  (:require
   [flow.subs :as subs]

   [re-frame.core :as rf]
   [markdown.core :as md]
   ))

(defn render-markdown [markdown-content]
  (let [html-content (md/md-to-html-string markdown-content)]
    [:div {:dangerouslySetInnerHTML {:__html html-content}}]))

(defn about-page [content]
  ;; [:p content]
  [render-markdown content]
  )

(defn cv-page [content]
  [:p content])

(defn repos-page [content]
  [:p content])
