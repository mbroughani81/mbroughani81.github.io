(ns flow.get-drops)

(def drops-dir "public/drops")

(defn gen-drops []
  (reduce
    (fn [acc f]
      (conj acc (read-string (slurp f))))
    []
    (.listFiles (java.io.File. drops-dir))))


(defmacro <-drops [] (gen-drops))

(comment
  (<-drops)

  ;;
  )
