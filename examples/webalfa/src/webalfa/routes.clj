(ns webalfa.routes
  (:require
    [compojure.core :refer [GET POST routes context]]
    [compojure.route :refer [resources not-found]]
    [webalfa.pages :as page]))

(defn pages-routes
  []
  (routes
    (GET "/" [ctx]
         "Just for the test")
    (GET "/soal" [ctx]
         "Ini bakal tempat soal")
    (GET "/content/:id" [id]
         (page/home-page id))))

(defn other-routes
  []
  (routes
    (resources "public/")
    (not-found "Ga ada apa2x")))

(defn main-routes []
  (routes (pages-routes)
          (other-routes)))
