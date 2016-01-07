(ns latex.generator2)
(use 'selmer.parser)

(def generator2
  (let [y (rand-nth (range -3 0))
        pangkat1 (rand-nth [3 5])

        z (rand-nth (range 1 6))

        x (Math/abs (- (int (Math/pow y pangkat1))
                       z))]
    {:x x
     :y y
     :z z

     :pangkat1 pangkat1}))


(def problem2
  (render
    "Tentukanlah x untuk persaman dibawah ini!
    $$ x = |{{y}}^{{pangkat1}} - {{z}}|$$
    <br>
    Maka x = {{x}}"

    generator2))