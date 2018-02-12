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

(defn tabs []
  (let [this (r/current-component)
        props (get-props this)
        {:keys [active on-before-change on-change]} props
        state (r/atom {:current active})
        children (get-children this)
        [[_ & tabs0] [_ & panels0]] children
        on-click #(let [index (-> (.-currentTarget %1)
                                  (.getAttribute "data-index"))
                        i (js/parseInt index 10)
                        j (:current @state)]
                    (when (not (= i j))
                      (if on-before-change
                        (when (on-before-change i j)
                          (when on-change
                            (on-change i j)))
                        (when on-change
                          (on-change i j)))))
        tabs (map-indexed #(into [:a.ui-tab-item {:data-index %1 :on-click on-click}] (rest %2)) tabs0)
        panels (map-indexed #(into [:div.ui-tab-panel] (rest %2)) panels0)]
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
        on-before-change #(if (= 1 %1) false true)
        on-change #(do (println "old=" %2 "new=" %1)
                       (reset! active %1))]
    (r/create-class
     {:component-did-mount
      (fn [] (js/setTimeout (fn []
                              (reset! active 1)) 2000))
      :display-name "app"
      :reagent-render
      (fn []
        [tabs {:active @active :on-change on-change}
         `[:tab-items
           ~@(map #(identity [:tab-item ^{:key %1} [:div %1]]) ["A" "B" "C"])]
         `[:tab-panels
           ~@(map #(identity [:tab-panel ^{:key %1} [:div %1]]) ["Panel A" "Panel B" "Panel C"])]])})))
