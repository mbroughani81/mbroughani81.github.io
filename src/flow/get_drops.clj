(ns flow.get-drops)

(def drops-dir "public/drops")

(defn gen-drops []
  (reduce
    (fn [acc f]
      (conj acc (read-string (slurp f))))
    []
    (.listFiles (java.io.File. drops-dir))))


(defmacro <-drops [] (gen-drops))

(def pages-dir "public/pages")

(defn gen-pages []
  (reduce
    (fn [acc f]
      (let [filename (keyword (.getName f))]
        (assoc acc filename (slurp f))))
    {}
    (.listFiles (java.io.File. pages-dir))))

(defmacro <-pages [] (gen-pages))

(comment
  (<-drops)

  (def x (<-pages))


  (-> x
      :about.md)

  ;;
  )
