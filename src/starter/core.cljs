(ns starter.core
  (:require [reagent.core :as r]
            [react-dom :as dom]))

(defonce greeting "hello")

(def who "jinwei")

(defn app []
  [:div greeting " " who])

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (js/console.log "jinwei...")
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export init []
  (js/console.log "hello world")
  (js/console.log dom)
  (start))
