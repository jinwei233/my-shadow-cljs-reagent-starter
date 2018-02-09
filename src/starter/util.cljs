(ns starter.util)

(defn get-window-width []
  (.-innerWidth js/window))

(defn get-window-height []
  (.-innerHeight js/window))
