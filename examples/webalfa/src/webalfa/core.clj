(ns webalfa.core
  (:require
    [org.httpkit.server :as webserver]
    [webalfa.routes :refer [main-routes]]
    [ring.middleware.defaults :refer :all]))

(defonce server (atom nil))

(defn start
  ([] (start 3000))
  ([port]
   (reset! server (-> (wrap-defaults (main-routes) site-defaults)
                      (webserver/run-server {:port port})))))

(defn stop
  []
  (@server))

(defn reset []
  (stop)
  (start))


