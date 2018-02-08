(ns cljsjs.react.dom
  (:require ["nervjs" :as react]
            ["nervjs" :as react-dom]))

(js/goog.object.set react "DOM" react-dom)
(js/goog.exportSymbol "ReactDOM" react-dom)
