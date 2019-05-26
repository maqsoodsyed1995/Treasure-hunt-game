(ns assignment2.core
  (:gen-class)
  (:require [clojure.string :as string])
  )


(def names (slurp "Example.txt"))

(def lines (string/split-lines names))

(def ls [])
(doseq [x lines]
  (def DB [])
  (doseq [y x]

    (def DB (conj DB y))
    )
  (def ls (conj ls DB))
  )

(def currentX 0)
(def currentY 0)
(def currenttempX 0)
(def currenttempY 0)
(def side false)

(defn Game []


  (while (not= (get (get ls currentX) currentY) (.charAt "@#!" 0))


    (do
         (println currentX)
         (println currentY)
         (println (get (get ls currentX) currentY))

         (if (= (get (get ls currentX) currentY) (.charAt "-#!" 0))
           (do (def c (assoc (get ls currentX) currentY "+"))
               (println (get (get ls currentX) currentY))
               (def currenttempY (+ currentY 1))
               (def ls (assoc ls currentX c ))
               )
           )
          (println currentY)

         (println (get (get ls currentX) currentY))
         (println (.charAt "-#!" 1))


         (if (= (get (get ls currentX) currentY) (.charAt "-#!" 1))
           (do


             (def currenttempY (- currentY 1))
             (def currenttempX (+ currentX 1))
             (println (get (get ls currentX) currentY))
             (def side false)

             )
           )

         (println currentX)
         )

    (println (type currenttempX))
    (def currentX (+ currenttempX 0) )
    (def currentY (+ currenttempY 0))



  )
         )

(Game)
(doseq [x ls]
  (println x)
  )
















