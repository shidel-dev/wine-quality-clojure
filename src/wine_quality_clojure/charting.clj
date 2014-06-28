(use '(incanter core stats charts))
(def x (range -1 5 0.01))
(def y (cos (mult 2 Math/PI x)))
(view (xy-plot x y))
