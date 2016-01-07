(ns problem001.generator)

(def generator
  (let [a (rand-nth (range 1 10))
        pangkat1 (rand-nth (range 2 5))

        b (rand-nth (range 2 5))
        pangkat2 (rand-nth (range 2 5))

        c (+ (int (Math/pow a pangkat1))
             (int (Math/pow b pangkat2)))]
    {:a        a
     :b        b
     :c        c

     :pangkat1 pangkat1
     :pangkat2 pangkat2}))