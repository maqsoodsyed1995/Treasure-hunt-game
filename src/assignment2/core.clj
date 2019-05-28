(ns assignment2.core
  (:gen-class)
  (:require [clojure.string :as string])
  )


(def currentX 0)
(def currentY 0)
(def xaxis '())
(def yaxis '())
(def ls [])


(defn loadFile []

  (def names (slurp "map.txt"))
  (def lines (string/split-lines names))

  (doseq [x lines]
    (def DB [])
    (doseq [y x]

      (def DB (conj DB y))
      )
    (def ls (conj ls DB))
    )

  )

(defn checkFile []

           (def listcount (count (get ls 0)))

           (doseq [lcount ls]

             (if (not= listcount  (count lcount))

               (do

                 (println "The Game Cannot be continued, File is not proper")
                 (System/exit 0)
                 )
               )

             )

           )


(defn Game []


  (doseq [x ls]

    (doseq [y x]

      (print y)
      (print " ")
      )
    (println " ")
    )

     (def c (assoc (get ls currentX) currentY "+"))
    (def ls (assoc ls currentX c ))


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

                (println "\n \nTreasure Not Found")
                (doseq [x ls]

                  (doseq [y x]

                    (print y)
                    (print " ")
                    )
                  (println " ")
                  )

                (System/exit 0)
                )



         )

  )





         )


  )


(loadFile)
(checkFile)
(Game)

(println " ")
(println "Woo hoo, I found the treasure :-) \n")
(doseq [x ls]

  (doseq [y x]

    (print y)
    (print " ")
    )
  (println " ")
  )
















