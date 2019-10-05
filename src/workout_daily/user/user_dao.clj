(ns workout-daily.user.user-dao
  (:require [workout-daily.database.database]
            [korma.core :refer :all]))

(defentity workout_user)

(defn get-users []
  "Gets all users in table workout_user"
  (select workout_user))

(defn get-user [id]
  "Gets user by id"
  (first
    (select workout_user
      (where {:id [= id]}))))

(defn add-user [name age height weight]
  "Adds new user in table workout-user with values: name, age, height, weight"
  (insert workout_user
    (values {:name name :age age :height height :weight weight})))

(defn delete-user [id]
  "Deletes a user by id"
  (delete workout_user
    (where {:id id}))
  {:status 200})

(defn update-user [id name]
  "Update just name of user by id"
  (let [total-upate
          (update workout_user
          (set-fields {:name name})
          (where {:id [= id]}))]
    {:total-update total-upate}))