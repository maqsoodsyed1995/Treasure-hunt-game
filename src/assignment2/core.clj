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
(def xaxis '())
(def yaxis '())

(defn Game []



     (def c (assoc (get ls currentX) currentY "+"))
    (def ls (assoc ls currentX c ))

     (doseq [x ls]
      (println x)
      )
  (while (not= (get (get ls currentX) currentY) (.charAt "@#!" 0))


    (do

      (cond

        (or (=  (get (get ls (+ 1 currentX)) currentY) (.charAt "-#!" 0))
            (= (get (get ls currentX) (+ 1 currentY)) (.charAt "-#!" 0))
            (= (get (get ls (- currentX 1 )) currentY) (.charAt "-#!" 0))
            (= (get (get ls currentX) (- currentY 1 )) (.charAt "-#!" 0))
            ) (do

                (cond

                  (= (get (get ls currentX) (+ 1 currentY)) (.charAt "-#!" 0)) (do

                                                                                 (def xaxis (cons currentX xaxis))
                                                                                 (def yaxis (cons currentY yaxis))
                                                                                 (def c (assoc (get ls currentX) currentY "+"))
                                                                                 (def ls (assoc ls currentX c ))
                                                                                 (def currentY (+ currentY 1) )
                                                                                 )

                  (=  (get (get ls (+ 1 currentX)) currentY) (.charAt "-#!" 0)) (do

                                                                                  (def xaxis (cons currentX xaxis))
                                                                                  (def yaxis (cons currentY yaxis))
                                                                                  (def c (assoc (get ls currentX) currentY "+"))
                                                                                  (def ls (assoc ls currentX c ))
                                                                                  (def currentX (+ currentX 1) )


                                                                                  )
                  (= (get (get ls currentX) (- currentY 1 )) (.charAt "-#!" 0)) (do
                                                                                  (def xaxis (cons currentX xaxis))
                                                                                  (def yaxis (cons currentY yaxis))
                                                                                  (def c (assoc (get ls currentX) currentY "+"))
                                                                                  (def ls (assoc ls currentX c ))
                                                                                  (def currentY (- currentY 1) )
                                                                                  )

                  (= (get (get ls (- currentX 1 )) currentY) (.charAt "-#!" 0)) (do

                                                                                  (def xaxis (cons currentX xaxis))
                                                                                  (def yaxis (cons currentY yaxis))
                                                                                  (def c (assoc (get ls currentX) currentY "+"))
                                                                                  (def ls (assoc ls currentX c ))

                                                                                  (def currentX (- currentX 1) )

                                                                                  )

                        )

        )

         )

  )

    (println currentX)
    (println currentY)
    (println xaxis)
    (println yaxis)

         )


  )

(Game)
(doseq [x ls]
  (println x)
  )
















