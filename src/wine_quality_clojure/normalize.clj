(ns normalize)

(defn matrix-transpose [matrix]
  (vec (apply map vector matrix)))

(defn to-min-mix [matrix]
  (vec (let [columns (matrix-transpose matrix)]
    (map (fn [col] (vector (apply min col) (apply max col))) columns))))

(defn rate[ranges row]
  (for [i (range 0 (count row))]
    (scale (ranges i) (row i))))

(defn scale [min-max num]
  (/ (- num (min-max 0)) (- (min-max 1) (min-max 0))))

(defn normalize-wine-inputs [matrix]
   (let [ranges (to-min-mix matrix)]
    (map #(rate ranges %) matrix)))

(normalize-wine-inputs [[1 6 8 9][3 7 0 4][3 7 9 0][7 4 3 2]])


