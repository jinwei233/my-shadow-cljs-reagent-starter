(ns starter.modal
  (:require [reagent.core :as r]))

(defn create-modal []
  (let [val (r/atom 0)
        root (js/document.body.appendChild (js/document.createElement "div"))
        update! (fn [] (swap! val inc))
        create-node (fn []
                      (js/console.log @val)
                      (react/createPortal (r/as-element [:div (str "count:" @val)]) root))]
    {:update! update!
     :create-node create-node}))

(defonce a-modal (create-modal))
