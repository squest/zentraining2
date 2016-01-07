(ns progen.core
  (:require [selmer.parser :as s])
  (:gen-class))

(defn numberone [themap] (spit "resources/result/01-persamaan-kuadrat.html" (s/render-file "html/01-persamaan-kuadrat.html" themap)))

(defn generate-one-digit-number [] (- (int (Math/floor (* (Math/random) 19))) 9))

(defn number-to-string [number]
  (if (< number 0) 
    (str number)
    (str "+" (str number))))

(defn number-to-string-1 [number]
  (cond 
    (> number 1) (str "+" (str number))
    (= number 1) "+"
    (= number -1) "-"
    (< number -1) (str number)))
    
(defn number-to-string-2 [number]
  (cond 
    (> number 0) (str "+" (str number))
    (< number 0) (str number)
    :default ""))

(defn get-b [x1 x2] (- (+ x1 x2)))

(defn get-c [x1 x2] (* x1 x2))

(defn get-map []
  (loop [x1 (generate-one-digit-number)
         x2 (generate-one-digit-number)]
    (if (= (get-b x1 x2) 0)
      (recur (generate-one-digit-number) (generate-one-digit-number))
      (hash-map :b (number-to-string-1 (get-b x1 x2)) :c (number-to-string-2 (get-c x1 x2))))))