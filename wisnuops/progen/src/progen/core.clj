(ns progen.core
  (:require [selmer.parser :as s])
  (:gen-class))

(defn numberone [themap] (spit "resources/result/01-persamaan-kuadrat.html" (s/render-file "html/01-persamaan-kuadrat.html" themap)))

(defn generate-one-digit-number [] (- (int (Math/floor (* (Math/random) 19))) 9))

(defn number-to-string [number]
  (cond 
    (> number 1) (str number)
    (= number 1) ""
    (= number -1) "-"
    (< number -1) (str number)))

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

; problem number two:

(defn numbertwo [themap] (spit "resources/result/02-pembagian-sukubanyak.html" (s/render-file "html/02-pembagian-sukubanyak.html" themap)))

(def maptwo {:a "3" :b "-2" :c "+5" :d "+19" :e "-8"})

(defn get-a-2 [] (inc (rand-int 3)))

(defn get-b-2 [a x1 x2 x3] (* (- a) (+ x1 x2 x3)))

(defn get-c-2 [a x1 x2 x3] (* a (+ (* x1 x2) (* x1 x3) (* x2 x3))))

(defn get-d-2 [a x1 x2 x3] (* (- a) x1 x2 x3))

(defn get-e-2 [x1] (- x1))

(defn get-map-2 []
  (loop [a (get-a-2)
        x1 (generate-one-digit-number)
        x2 (generate-one-digit-number)
        x3 (generate-one-digit-number)]
    (if (or (= (get-b-2 a x1 x2 x3) 0)
            (= (get-c-2 a x1 x2 x3) 0)
            (= (get-d-2 a x1 x2 x3) 0)
            (= (get-e-2 x1) 0))
      (recur a (generate-one-digit-number) (generate-one-digit-number) (generate-one-digit-number))
      (hash-map :a (number-to-string a) 
                :b (number-to-string-1 (get-b-2 a x1 x2 x3))
                :c (number-to-string-1 (get-c-2 a x1 x2 x3))
                :d (number-to-string-2 (get-d-2 a x1 x2 x3))
                :e (number-to-string-2 (get-e-2 x1))))))

