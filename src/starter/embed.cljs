(starter.embed
 (:require-macros [util.core :refer [load-file-in-compile embed-svg]]))

(defn react-svg []
  "reagent svg component from file"
  (embed-svg "public/svg/react.svg"))
