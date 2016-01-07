(ns progen.core
  (:require [selmer.parser :as s])
  (:gen-class))

(defn numberone [themap] (spit "resources/result/01-persamaan-kuadrat.html" (s/render-file "html/01-persamaan-kuadrat.html" themap)))

(defn generate-one-digit-number [] (- (int (Math/floor (* (Math/random) 19))) 9))

(defn number-to-string [number]
  (if (< number 0) 
    (clojure.string/replace (str number) #"-" "- ") 
    (str "+ " (str number))))

(defn get-b [x1 x2] (- (+ x1 x2)))

(defn get-c [x1 x2] (* x1 x2))

(defn get-map []
  (let 
    [x1 (generate-one-digit-number)
     x2 (generate-one-digit-number)]
    (hash-map :b (number-to-string (get-b x1 x2)) :c (number-to-string (get-c x1 x2)))))