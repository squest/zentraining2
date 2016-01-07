(ns latex.soalmaker
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]))
(use 'selmer.parser)

(defn makesoal
  ([body] (hp/html5

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
                body]

               ])))


;(spit "resources/problem1.html" (makesoal latex.generator1/problem1))
