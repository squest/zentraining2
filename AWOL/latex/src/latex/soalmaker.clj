(ns latex.soalmaker
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]))
(use 'selmer.parser)


(defn html
  [body]
  (hp/html5
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
      body]]))

(defn soalmaker
  [[& folder] generator done-name]
  ;problem002/ 1/
  ;problem002.generator/generator

  (let [body (render
               (slurp (->> (str (apply str folder) "text.html")
                           (str "resources/")))
               generator)]

    (spit (str "resources/Done/" done-name)

          (html body))))

(def sample
  (soalmaker ["problem001/" "1/"]
             problem001.generator/generator
             "sample.html"))

;(spit "resources/problem1.html" (makesoal latex.generator1/problem1))
