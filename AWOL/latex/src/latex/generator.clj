(ns latex.generator)
(use 'selmer.parser)

;(spit "resources/problem1.html" (render "Hello {{name}}!" {:name "Yogthos"}))

(def sample
  (let [teta (rand-nth [30 37 45 60])
        m (rand-nth (range 1 51))
        s (rand-nth (range 1 201))
        f (rand-nth (range 1 501))
        g (rand-nth [9.8 10])
        n (* m g)]
    {:teta teta
     :m    m
     :g    g
     :N    n

     :f    f
     :s    s}))