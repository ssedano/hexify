(ns hexify.core
  (:gen-class))

(defn hexify [s]
  (format "%x" (new java.math.BigInteger (.getBytes s))))

(defn dotted [s]
  (let [hex (hexify s)]
    (clojure.string/join ":" (re-seq #"\w{2}" hex))))

(defn -main [& args]
  (if args
    (let [input (clojure.string/join " " args)]
      (println (dotted input)))
    (println "Input is required!")))
