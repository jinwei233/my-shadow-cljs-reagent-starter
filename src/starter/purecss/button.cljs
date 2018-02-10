(ns starter.purecss.button)

(defn button [text {:keys
                    [primary?
                     secondary?
                     success?
                     error?
                     warning?
                     disable?
                     active?
                     small?
                     xsmall?
                     large?
                     xlarge?
                     custom-class]}]
  [:button
   {:class ["pure-button"
            (if disable? "pure-button-disabled")
            (if active? "pure-button-active")
            (if primary? "pure-button-primary")
            (if secondary? "button-secondary")
            (if success? "button-success")
            (if error? "button-error")
            (if small? "button-small")
            (if xsmall? "button-xsmall")
            (if large? "button-large")
            (if xlarge? "button-xlarge")
            (if custom-class custom-class)]} text])

(defn button-demo []
  [:div
   [:p
    [button "A Pure Button" {:success? true :large? true}]
    [:span " "]
    [button "A Pure Button" {:success? true :xsmall? true}]]
   [:p "TODO button group"]
   [:p "TODO button with icon"]])
