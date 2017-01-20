(def options '("Rock", "Paper", "Scissors"))

(defn printoptions [options]
  (print "| ")
  (doseq [n options] (print n) (print " | "))
  (println))

(defn printstart []
  (println " ------------------------- ")
  (println "|   Welcome to the Game   |")
  (println "|    Choose your Hand:    |")
  (printoptions options))

(defn spaces [x] (apply str (repeat x \space)))

(defn prompt-read []
  (print (format "|  >>   ")) (flush) (read-line))


(defn printchoices [userchoice, pcchoice]
  (println "| User shows: " userchoice (spaces (- 9 (count userchoice))) "|")
  (println "|   PC shows: " pcchoice (spaces (- 9 (count pcchoice))) "|")
  )

(defn printresult [result]
  (println "|                         |")
  (println "|" (spaces (/ (- 22 (count result)) 2)) result (spaces (/ (- 22 (count result)) 2)) "|")
  (println " ------------------------- "))


(defn generateresult [userchoice, pcchoice]
  (printchoices userchoice pcchoice)
  (cond
    (= (.indexOf options userchoice) (.indexOf options pcchoice)) (printresult "DRAW: No One Wins")
    (= (+ (.indexOf options pcchoice) 1) (.indexOf options userchoice)) (printresult "USER wins")
    (= (+ (.indexOf options userchoice) 2) (.indexOf options pcchoice)) (printresult "USER wins")
    (= (+ (.indexOf options userchoice) 1) (.indexOf options pcchoice)) (printresult "COMPUTER wins")
    (= (+ (.indexOf options pcchoice) 2) (.indexOf options userchoice)) (printresult "COMPUTER wins")
    :else "|  Something went wrong   |"))

(printstart)

(def pcchoice (str (nth options (rand-int 3))))
(def userchoice (prompt-read))

(println (generateresult userchoice pcchoice))

