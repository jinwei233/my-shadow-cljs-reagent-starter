(ns starter.core
  (:require [reagent.core :as r]
            [starter.util :as util]))

(defonce greeting "hello")

(def who "tom")

(defn app []
  [:div greeting " " who])

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (r/render [app]
            (.getElementById js/document "app")))

(js/console.log (#(js/console.log %2) "A" "B"))

(defn ^:export init []
  (start))
