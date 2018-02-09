(ns starter.core
  (:require [reagent.core :as r]                        
            [starter.svg :refer [concentric-circles]])
  (:require-macros [util.core :refer [load-file-in-compile]]))

(defonce greeting "hello")

(def who "jinwei")

(defn app []
  [:div
   [:div greeting " " who]
   [concentric-circles]])

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (r/render [app]
            (.getElementById js/document "app")))

(js/console.log (load-file-in-compile "shadow-cljs.edn"))

(defn ^:export init []
  (start))
