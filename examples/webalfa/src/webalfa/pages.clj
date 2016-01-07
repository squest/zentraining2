(ns webalfa.pages
  (:require
    [selmer.parser :refer [render-file]]))

(defn home-page
  [id]
  (render-file "templates/base.html"
               {:ids (for [id (range (read-string id))]
                       (str "Content no " id))}))
