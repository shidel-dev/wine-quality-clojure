(ns importer)

(require '[clojure.data.csv :as csv]
         '[clojure.java.io :as io])

(defn read-file [file]
(with-open [in-file (io/reader file)]
  (doall
    (csv/read-csv in-file :separator \;))))

(defn csv-to-hash-map [parsed-csv]
  (map #(zipmap (first parsed-csv) %) (rest parsed-csv)))

