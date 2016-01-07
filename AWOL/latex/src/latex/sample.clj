(ns latex.sample
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]))
(use 'selmer.parser)


(defn makesoal
  ([& body] (hp/html5

              [:html

               [:head
                "<script type=\"text/javascript\">
                window.MathJax = {tex2jax: {inlineMath: [ ['$','$'],
                 [\"\\
                \\(\",\"\\\\)\"] ],
                processEscapes: false}};
                </script>"

                "<script type=\"text/javascript\"
                 src=\"http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML\">
                 </script>"]

               [:body
                body]])))


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

(def problem
  (render
    "Untuk nilai x = 50\n\nBilangan yang kita kenal dan biasa kita tulis adalah dalam basis 10.
    \n\n123 bermakna $ (1 * 10^2) + (2 * 10^1) + (3 * 10^0) $\n\n
    Dalam basis 4, 123 dituliskan sebagai 1323 karena\n$$ 123 = (1* 4^3) + (3*4^2) + (2*4^1) + (3*4^0) $$\n\n
Berapakah 1209380934 jika dituliskan di basis 6? {{name}}!"
    {:name "Yogthos"}))