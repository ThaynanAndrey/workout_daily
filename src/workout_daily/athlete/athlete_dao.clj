(ns workout-daily.athlete.athlete-dao
  (:require [workout-daily.database.database]
            [korma.core :refer :all]))

(defentity athlete)

(defn get-athletes []
  "Gets all athletes in table athlete"
  (select athlete))

(defn get-athlete [id]
  "Gets athlete by id"
  (first
    (select athlete
      (where {:id [= id]}))))

(defn add-athlete [name age height weight]
  "Adds new athlete in table workout-athlete with values: name, age, height, weight"
  (insert athlete
    (values {:name name :age age :height height :weight weight})))

(defn delete-athlete [id]
  "Deletes a athlete by id"
  (delete athlete
    (where {:id id}))
  {:status 200})

(defn update-athlete [id name]
  "Update just name of athlete by id"
  (let [total-upate
          (update athlete
          (set-fields {:name name})
          (where {:id [= id]}))]
    {:total-update total-upate}))