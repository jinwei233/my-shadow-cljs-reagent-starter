;; TODO modal
;; 单例模式、多例
;; API 设计
;; ref https://github.com/Frozenlock/reagent-modals/blob/master/src/reagent_modals/modals.cljs
;; TODO table
;; 1) http://facebook.github.io/fixed-data-table
;; 2) https://github.com/Frozenlock/reagent-table 很赞
;; TODO add more custom method for reagent component 
;; TODO 添加 attrs 验证
;; https://github.com/Day8/re-com/blob/master/src/re_com/popover.cljs
;; TODO debounce 实现
;; https://github.com/Day8/re-com/blob/master/src/re_com/typeahead.cljs
;; TODO micro reagent framework
;; https://github.com/keechma/keechma
;; TODO material-ui binding
;; https://github.com/DaveWM/reagent-material-ui
;; TODO semantics ui wrapper
;; https://github.com/gadfly361/soda-ash
;; context-menu
;; https://github.com/Frozenlock/reagent-contextmenu/blob/master/src/reagent_contextmenu/menu.cljs 推荐
;; draggable 
;; https://github.com/borkdude/draggable-button-in-reagent/blob/master/src-cljs/drag/main.cljs 推荐
;; re-frame devtools
;; https://github.com/flexsurfer/re-frisk
(ns starter.core
  (:require [reagent.core :as r]
            ["react" :as react]
            [reagent.debug :as debug]
            [starter.ref :refer [ref-comp]]
            [starter.util :as util]
            [starter.svg :refer [clojure-icon-svg]]))

(defn app []
  [:div "it works"])

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
