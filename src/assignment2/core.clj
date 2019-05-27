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


(def xaxis '())
(def yaxis '())

(defn Game []



     (def c (assoc (get ls currentX) currentY "+"))
    (def ls (assoc ls currentX c ))

     (doseq [x ls]
      (println x)
      )
  (while (and (not=  (get (get ls (+ 1 currentX)) currentY) (.charAt "@#!" 0))
             (not= (get (get ls currentX) (+ 1 currentY)) (.charAt "@#!" 0))
             (not= (get (get ls (- currentX 1 )) currentY) (.charAt "@#!" 0))
             (not= (get (get ls currentX) (- currentY 1 )) (.charAt "@#!" 0))
             )


    (do

      (cond

        (or (=  (get (get ls (+ 1 currentX)) currentY) (.charAt "-#!" 0))
            (= (get (get ls currentX) (+ 1 currentY)) (.charAt "-#!" 0))
            (= (get (get ls (- currentX 1 )) currentY) (.charAt "-#!" 0))
            (= (get (get ls currentX) (- currentY 1 )) (.charAt "-#!" 0))
            ) (do
                  (println "inside first if ")
                (cond

                  (= (get (get ls currentX) (+ 1 currentY)) (.charAt "-#!" 0)) (do

                                                                                 (def xaxis (cons currentX xaxis))
                                                                                 (def yaxis (cons currentY yaxis))
                                                                                 (def c (assoc (get ls currentX) (+ 1 currentY) "+"))
                                                                                 (def ls (assoc ls currentX c ))
                                                                                 (def currentY (+ currentY 1) )
                                                                                 )

                  (=  (get (get ls (+ 1 currentX)) currentY) (.charAt "-#!" 0)) (do

                                                                                  (def xaxis (cons currentX xaxis))
                                                                                  (def yaxis (cons currentY yaxis))
                                                                                  (def c (assoc (get ls (+ 1 currentX)) currentY "+"))
                                                                                  (def ls (assoc ls (+ 1 currentX) c ))
                                                                                  (def currentX (+ currentX 1) )


                                                                                  )
                  (= (get (get ls currentX) (- currentY 1 )) (.charAt "-#!" 0)) (do
                                                                                  (def xaxis (cons currentX xaxis))
                                                                                  (def yaxis (cons currentY yaxis))
                                                                                  (def c (assoc (get ls currentX) (- currentY 1 ) "+"))
                                                                                  (def ls (assoc ls currentX c ))
                                                                                  (def currentY (- currentY 1) )
                                                                                  )

                  (= (get (get ls (- currentX 1 )) currentY) (.charAt "-#!" 0)) (do

                                                                                  (def xaxis (cons currentX xaxis))
                                                                                  (def yaxis (cons currentY yaxis))
                                                                                  (def c (assoc (get ls (- currentX 1 )) currentY "+"))
                                                                                  (def ls (assoc ls (- currentX 1 ) c ))

                                                                                  (def currentX (- currentX 1) )

                                                                                  )

                        )

        )

        (or (=  (get (get ls (+ 1 currentX)) currentY) (str (.charAt "#+!" 1)))
            (= (get (get ls currentX) (+ 1 currentY)) (str (.charAt "#+!" 1)))
            (= (get (get ls (- currentX 1 )) currentY) (str (.charAt "#+!" 1)))
            (= (get (get ls currentX) (- currentY 1 )) (str (.charAt "#+!" 1)))
            ) (do
                 (println "insode second")
                (cond

                  (= (get (get ls currentX) (+ 1 currentY)) (str (.charAt "#+!" 1))) (do

                                                                                 (def xco (first xaxis))
                                                                                 (def yco (first yaxis))

                                                                                 (def c (assoc (get ls currentX) currentY "!"))
                                                                                 (def ls (assoc ls currentX c ))
                                                                                 (def currentX xco)
                                                                                 (def currentY yco)
                                                                                 (def xaxis (rest xaxis))
                                                                                 (def yaxis (rest yaxis))
                                                                                 )

                  (=  (get (get ls (+ 1 currentX)) currentY) (str (.charAt "#+!" 1))) (do

                                                                                  (def xco (first xaxis))
                                                                                  (def yco (first yaxis))

                                                                                  (def c (assoc (get ls currentX) currentY "!"))
                                                                                  (def ls (assoc ls currentX c ))
                                                                                  (def currentX xco)
                                                                                  (def currentY yco)
                                                                                  (def xaxis (rest xaxis))
                                                                                  (def yaxis (rest yaxis))


                                                                                  )
                  (= (get (get ls currentX) (- currentY 1 )) (str (.charAt "#+!" 1))) (do
                                                                                  (def xco (first xaxis))
                                                                                  (def yco (first yaxis))

                                                                                  (def c (assoc (get ls currentX) currentY "!"))
                                                                                  (def ls (assoc ls currentX c ))
                                                                                  (def currentX xco)
                                                                                  (def currentY yco)
                                                                                  (def xaxis (rest xaxis))
                                                                                  (def yaxis (rest yaxis))
                                                                                  )

                  (= (get (get ls (- currentX 1 )) currentY) (str (.charAt "#+!" 1))) (do

                                                                                  (def xco (first xaxis))
                                                                                  (def yco (first yaxis))
                                                                                  (def c (assoc (get ls currentX) currentY "!"))
                                                                                  (def ls (assoc ls currentX c ))
                                                                                  (def currentX xco)
                                                                                  (def currentY yco)
                                                                                  (def xaxis (rest xaxis))
                                                                                  (def yaxis (rest yaxis))

                                                                                  )

                  )

                )

        :else (do
                (println "Treasure Not Found")
                (doseq [x ls]
                  (println x)
                  )

                (System/exit 0)
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
















