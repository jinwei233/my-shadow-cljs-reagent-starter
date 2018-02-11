(ns starter.tab
  (:require [clojure.string :refer [split]]
            [reagent.core :as r]
            [reagent.impl.template :refer [convert-props]]
            [reagent.impl.component :refer [get-props get-children]]))

(defn- merge-class [{:keys [class] :as attrs} extra]
  (if (vector? class)
    (merge attrs {:class (distinct (into class [extra]))})
    (merge attrs {:class (distinct (into (split class #"\s+") [extra]))})))

(defn- add-class [item class]
  (let [[a b & c] item]
    (if c
      [a (merge-class b class) c]
      [a {:class class} b])))

(defn- add-active-class [arr cur]
  (map-indexed
   (fn [index item]
     (if (= cur index)
       (add-class item "active")
       item)) arr))

(defn- get-tabs-and-panels [children]
  (let [[[_ & tabs0] [_ & panels0]] children]
    [tabs0 panels0]))

(defn- build-tabs-and-panels [children on-click]
  (let [[tabs0 panels0] (get-tabs-and-panels children)
        tabs (map-indexed #(into [:a.ui-tab-item {:data-index %1 :on-click on-click}] (rest %2)) tabs0)
        panels (map-indexed #(into [:div.ui-tab-panel] (rest %2)) panels0)]
    [tabs panels]))

(defn tabs []
  (let [this (r/current-component)
        props (get-props this)
        {:keys [active on-change]} props
        state (r/atom {:current active})
        children (get-children this)
        on-click #(let [index (-> (.-currentTarget %1)
                                  (.getAttribute "data-index"))
                        i (js/parseInt index 10)
                        j (:current @state)]
                    (when (not (= i j))
                      (when on-change (on-change j i))
                      (swap! state assoc :current i)))
        [tabs panels] (build-tabs-and-panels children on-click)]
    (r/create-class
     {:component-will-receive-props
      (fn [_ next-this]
        (let [[_ {:keys [active]}] next-this
              old (:current @state)]
          (when (not (= old active))
            (println "receive updates active=" active)
            (swap! state assoc :current active))))
      :display-name "ui-tab"
      :reagent-render
      (fn []
        (into
         [:div.ui-tab]
         [(into [:div.ui-tab-items]
                (add-active-class tabs (:current @state)))
          (into [:div.ui-tab-panels]
                (add-active-class panels (:current @state)))]))})))

(defn tabs-demo []
  "demo to test updates"
  (let [active (r/atom 0)
        on-change #(do (println "old=" %1 "new=" %2)
                       (reset! active %2))]
    (r/create-class
     {:component-did-mount
      (fn [] (js/setTimeout (fn []
                              (reset! active 1)) 2000))
      :display-name "app"
      :reagent-render
      (fn []
        [tabs {:active @active :on-change on-change}
         [:tab-items
          [:tab-item [:span {:key "A"} "A"]]
          [:tab-item [:span {:key "B"} "B"]]]
         [:tab-panels
          [:tab-panel "C"]
          [:tab-panel "D"]]])})))
    
