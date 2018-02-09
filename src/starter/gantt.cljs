(ns starter.gantt
  (:require [reagent.core :as r]
            ["virtual-dom-stringify" :as virtual-dom-stringify]
            ["virtual-dom/create-element" :as create-element]
            ["gantt-chart" :as chart]))

(def tree-data
  #js {:wow #js {:dependencies #js [ "amaze" ],
             :duration "1 week"},
       :amaze #js {:duration "3 days"},
       :cool #js {:duration "6 days"},
       :whatever #js {:duration "1 day",
                      :dependencies #js [ "wow" ]},
       :very #js {:duration "2 days",
                  :dependencies #js [ "amaze" ]},
       :great #js {:duration "8 days",
                   :dependencies #js [ "very" ]}
       })

;; append to body
;; (.appendChild (.getElementById js/document "app") (create-element (.tree (chart tree-data))))
