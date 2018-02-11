;; TODO modal
;; 单例模式、多例
;; API 设计
;; ref https://github.com/Frozenlock/reagent-modals/blob/master/src/reagent_modals/modals.cljs
;; TODO table
;; http://facebook.github.io/fixed-data-table
;; TODO add more custom method for reagent component 
(ns starter.core
  (:require [reagent.core :as r]
            [reagent.debug :as debug]
            [starter.ref :refer [ref-comp]]
            [starter.util :as util]
            [starter.svg :refer [clojure-icon-svg]])
  (:require-macros [util.core :refer [load-file-in-compile embed-svg]]))

(defn react-svg []
  "reagent svg component from file"
  (embed-svg "public/svg/react.svg"))

(defn app []
  [:div
   [ref-comp]])

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
