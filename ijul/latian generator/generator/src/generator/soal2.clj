(ns generator.core
  (:require [selmer.parser :as s])
  (:gen-class))

(defn -main
  []
  (println "Hello, World!"))

(defn soal2
  []
  (let [V (rand-nth (range 1 101))
        P (rand-nth (range 1 21))
        C (rand-nth (range 20 32))
        T (+ 273 C)
        R 0.082
        mr 16
        n (/ (* P V) (* R T))
        gr (Math/round (* n mr))]
    {:V (str V) :P (str P) :C (str C) :gr (str gr)}))

(defn -render []
  (s/render (slurp "E:/latian generator/generator/resources/html/soal2.html") 
            {:V (:V (soal2)) 
             :P (:P (soal2)) 
             :C (:C (soal2))
             :gr (:gr (soal2))
             }))

(defn -spit []
  (spit "E:/latian generator/generator/resources/result/soal2.html" (-render)))
