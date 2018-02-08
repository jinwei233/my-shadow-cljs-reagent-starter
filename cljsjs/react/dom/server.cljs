(ns cljsjs.react.dom.server
  (:require ["nerv-server" :as rdom]))

(js/goog.exportSymbol "ReactDOMServer" rdom)
