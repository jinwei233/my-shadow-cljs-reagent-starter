(ns starter.purecss.table)

(defn table [{:keys
              [bordered?
               horizontal?
               striped?]}]
  [:table
   {:class ["pure-table"
            (if bordered? "pure-table-bordered")
            (if horizontal? "pure-table-horizontal")
            (if striped? "pure-table-striped")]}
   [:thead
    [:tr
     [:th "#"]
     [:th "Make"]
     [:th "Model"]
     [:th "Year"]]]
   [:tbody
    [:tr
     [:td "1"]
     [:td "Honda"]
     [:td "Accord"]
     [:td "2009"]]
    [:tr
     [:td "2"]
     [:td "Toyota"]
     [:td "Camry"]
     [:td "2012"]]
    [:tr
     [:td "3"]
     [:td "Hyundai"]
     [:td "Elantra"]
     [:td "2010"]]]])

(defn table-demo []
  [:div
   [table]
   [:br]
   [table {:bordered? true}]
   [:br]
   [table {:horizontal? true}]
   [:br]
   [table {:striped? true}]])
