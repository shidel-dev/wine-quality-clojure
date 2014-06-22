(ns wine-quality-clojure.importer-test
  (:require [clojure.test :refer :all]))

(load "importer")

(deftest can-read-csv-as-clojure-objects
  (testing "reads csv files"
    (is (= ["fixed acidity" "volatile acidity" "citric acid" "residual sugar" "chlorides" "free sulfur dioxide" "total sulfur dioxide" "density" "pH" "sulphates" "alcohol" "quality"]
       (first (importer/read-file "resources/winequality-red.csv"))))))

(deftest creates-hash-map
  (testing "creates a hash map from parsed csv"
    (is (= (first (importer/csv-to-hash-map (importer/read-file "resources/winequality-red.csv"))) {"sulphates" "0.56", "fixed acidity" "7.4", "density" "0.9978", "free sulfur dioxide" "11", "volatile acidity" "0.7", "alcohol" "9.4", "total sulfur dioxide" "34", "chlorides" "0.076", "pH" "3.51", "residual sugar" "1.9", "quality" "5", "citric acid" "0"}))))









