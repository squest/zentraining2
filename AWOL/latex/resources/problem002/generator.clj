(ns problem002.generator)

(def generator
  (let [y (rand-nth (range -3 0))
        pangkat1 (rand-nth [3 5])

        z (rand-nth (range 1 6))

        x (Math/abs (- (int (Math/pow y pangkat1))
                       z))]
    {:x x
     :y y
     :z z

     :pangkat1 pangkat1}))