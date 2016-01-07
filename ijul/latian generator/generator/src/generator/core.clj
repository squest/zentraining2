(ns generator.core
  (:require [selmer.parser :as s])
  (:gen-class))

(defn -main
  []
  (println "Hello, World!"))




(defn soal1 []
  (let [molar-hcl (rand-nth [1 0.1 0.01 0.01])
        volume-hcl (rand-nth [1 0.1 0.01 0.01])
        volume-air (rand-nth [1000 100 10 1])
        molar-hcl-baru (/(* molar-hcl volume-hcl) volume-air)
        ph (int (* -1 (Math/log10 molar-hcl-baru)))]
    {:molar-hcl (str molar-hcl)
     :volume-hcl (str volume-hcl)
     :volume-air (str volume-air)
     :ans (str ph)}
))                            

(defn -render []
  (s/render (slurp "E:/latian generator/generator/resources/html/soal.html") 
            {:molar-hcl (:molar-hcl (soal1)) 
             :volume-hcl (:volume-hcl (soal1)) 
             :volume-air (:volume-air (soal1))
             :ans (:ans (soal1))
             }))
(defn -spit []
  (spit "E:/latian generator/generator/resources/result/soal.html" (-render)))
