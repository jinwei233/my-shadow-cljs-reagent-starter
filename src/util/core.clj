(ns util.core
  (:require [hiccup-bridge.core :as hicv])
  (:import java.io.File))

(defmacro load-file-in-compile
  "Reads a file and returns it as a string"
  [relative-path]
  (slurp relative-path))

(defmacro embed-svg [file-dest]
  (let [[result] (hicv/html->hiccup (slurp file-dest))]
    `~result))
