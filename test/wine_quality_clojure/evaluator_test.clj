(ns wine-quality-clojure.importer-test
  (:require [clojure.test :refer :all]))

(load "evaluator")

(deftest can-classify
  (testing "can classify an output"
    (is (= (evaluator/classify [0 0 1 0 0]) 3))))
