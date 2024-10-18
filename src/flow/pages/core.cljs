(ns flow.pages.core
  (:require
   [flow.subs :as subs]

   [re-frame.core :as rf]
   [markdown.core :as md]))

(defn render-markdown [markdown-content]
  (let [html-content (md/md-to-html-string markdown-content)]
    [:div.content-holder {:dangerouslySetInnerHTML {:__html html-content}}]))

(defn about-page [content]
  ;; [:p content]
  ;; [render-markdown content]
  [:div {:style {:display "flex" :justify-content "space-between" :align-items "flex-start"}}
   [:div ;; Content on the left
    [render-markdown content]]
   [:div {:style {:display "flex" :flex-direction "column" :align-items "center" :margin-left "50px"}}
    [:img {:src   "images/profile.jpg"
           :alt   "Description of the image"
           :style {:max-width     "200px" ;; Adjust the size as needed
                   :box-shadow    "0 4px 8px rgba(0, 0, 0, 0.5)" ;; Horizontal offset, vertical offset, blur radius, color
                   :border-radius "10px"
                   }}]
    [:div {:style {:margin-top "10px"}}
     [:a {:href "mailto:mbroughani81@gmail.com" :style {:margin "0 10px"}}
      [:i {:class "fas fa-envelope" :style {:font-size "24px" :color "black"}}]]
     [:a {:href "https://github.com/mbroughani81" :target "_blank" :style {:margin "0 10px"}}
      [:i {:class "fab fa-github" :style {:font-size "24px" :color "black"}}]]
     [:a {:href "https://www.linkedin.com/in/mohammad-broughani-472837214" :target "_blank" :style {:margin "0 10px"}}
      [:i {:class "fab fa-linkedin" :style {:font-size "24px" :color "black"}}]]
     ]]])

(defn cv-page [content]
  [:p content])

(defn repos-page [content]
  [:p content])
