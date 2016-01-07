(defproject webalfa "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [http-kit "2.1.18"]
                 [lib-noir "0.9.9"]
                 [ring/ring-defaults "0.1.5"]
                 [selmer "0.9.8"]
                 [ring "1.4.0"]
                 [danlentz/clj-uuid "0.1.6"]
                 [cheshire "5.5.0"]]

  :source-paths ["src/clj"]

  :resource-paths ["resources"])
