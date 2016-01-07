(ns latex.generator1)
(use 'selmer.parser)

(def generator1
  (let [a (rand-nth (range 1 10))
        pangkat1 (rand-nth (range 2 5))

        b (rand-nth (range 2 5))
        pangkat2 (rand-nth (range 2 5))

        c (+ (int (Math/pow a pangkat1))
             (int (Math/pow b pangkat2)))]
    {:a a
     :b b
     :c c

     :pangkat1 pangkat1
     :pangkat2 pangkat2}))


(def problem1
  (render
    "Untuk $a^{{pangkat1}} + b^{{pangkat2}} = c$
    <br>
    Jika diketahui a = {{a}} dan b = {{a}}
    <br>
    Maka c = {{c}}"

    generator1))
