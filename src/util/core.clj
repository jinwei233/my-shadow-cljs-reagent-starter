(ns util.core
  (:import java.io.File))

(defmacro load-file-in-compile
  "Reads a file and returns it as a string"
  [relative-path]
  (slurp relative-path))
