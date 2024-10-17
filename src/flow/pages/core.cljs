(ns flow.pages.core
  (:require
   [flow.subs :as subs]

   [re-frame.core :as rf]
   [markdown.core :as md]))

(defn render-markdown [markdown-content]
  (let [html-content (md/md-to-html-string markdown-content)]
    [:div {:dangerouslySetInnerHTML {:__html html-content}}]))

(defn about-page [content]
  ;; [:p content]
  ;; [render-markdown content]
  [:div {:style {:display "flex" :justify-content "space-between" :align-items "flex-start"}}
   [:div ;; Content on the left
    [render-markdown content]]
   [:img {:src   "images/profile.jpg"
          :alt   "Description of the image"
          :style {:max-width   "200px"  ;; Adjust the size as needed
                  :margin-left "20px"}}]])

(defn cv-page [content]
  [:p content])

(defn repos-page [content]
  [:p content])
