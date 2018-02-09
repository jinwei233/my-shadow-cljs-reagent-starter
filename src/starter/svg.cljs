(ns starter.svg)

(defn concentric-circles []
  [:svg {:style {:border "1px solid"
                 :background "white"
                 :width "150px"
                 :height "150px"}}
   [:circle {:r 50, :cx 75, :cy 75, :fill "green"}]
   [:circle {:r 25, :cx 75, :cy 75, :fill "blue"}]
   [:path {:stroke-width 12
           :stroke "white"
           :fill "none"
           :d "M 30,40 C 100,40 50,110 120,110"}]])
