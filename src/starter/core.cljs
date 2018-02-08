(ns starter.core
  (:require [reagent.core :as r]
            [reagent.dom.server :refer [render-to-string]]))

(defonce greeting "hello")

(def who "jinwei")

(defn app []
  [:div greeting " " who])

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (js/console.log (render-to-string [app]))
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export init []
  (start))
