(ns starter.core
  (:require [reagent.core :as r]
            [starter.util :as util]
            [reagent.debug :as debug]
            [starter.svg :refer [clojure-icon-svg]])
  (:require-macros [util.core :refer [load-file-in-compile embed-svg]]))

(defn react-svg []
  "reagent svg component from file"
  (embed-svg "public/svg/react.svg"))

(defn app []
  [:div
   (react-svg)
   [clojure-icon-svg]])

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (r/render [app]
            (.getElementById js/document "app")))

;; (js/console.log (load-file-in-compile "shadow-cljs.edn"))
;; (debug/prn (react-svg))

(defn ^:export init []
  (start))
