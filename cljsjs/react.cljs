(ns cljsjs.react
  (:require ["nervjs" :as react]
            ["nerv-create-class" :as crc]))

(defn ^:export my-debug []
  (js/console.log "hi world")
  (js/console.log react/Component))

(js/goog.object.set react "createClass" crc)
(js/goog.exportSymbol "React" react)
