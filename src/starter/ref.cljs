(ns starter.ref
  (:require [reagent.core :as r]))

(defn- a-div []
  (let [this (r/current-component)]
    [:div (str (r/props this))]))

(defn ref-comp []
  (r/create-class
   {:component-did-mount  
    #(js/console.log "hello")
    :component-will-mount
    #(println "component-will-mount")
    :component-did-update
    #(println "did-update")
    :component-will-unmount
    #(println "component-will-unmount") 
    :display-name  "a-ref-component" 
    :custom-method #(println "from custom method")
    :reagent-render
    (fn []
      ;; (r/current-component)
      [a-div {:name "jinwei"}])}))

