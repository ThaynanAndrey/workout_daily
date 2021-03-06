(ns workout-daily.dao.workout.workout-dao
    (:require [workout-daily.config.database.database]
            [korma.core :refer :all]))

(defentity workout)
(defentity athlete)

(defn get-all-athlete-workouts [id-athlete]
    "Gets all workouts of athlete in table workout"
    (select workout
        (join athlete (= :athlete.id :workout.id_athlete))
        (where {:workout.id_athlete [= id-athlete]})))

(defn get-athlete-workout [id-workout id-athlete]
    "Gets workout of athlete by id"
    (select workout
        (join athlete (= :athlete.id :workout.id_athlete))
        (where (and (= :workout.id_athlete id-athlete) (= :workout.id id-workout)))))

(defn add-workout-to-athlete [name id_athlete creation_date]
    "Adds new workout to athlete with values: name id_athlete creation_date"
    (let [value-default {:name name :id_athlete id_athlete}
          value-to-insert (if (nil? creation_date) value-default
                            (conj value-default {:creation_date creation_date}))]
        (insert workout
            (values value-to-insert))))

(defn delete-workout [id]
    "Deletes a workout by id"
    (delete workout
        (where {:id id}))
    {:status 200})

(defn update-workout [id name]
    "Update just name of workout by id"
    (let [total-upate
            (update workout
                (set-fields {:name name})
                (where {:id [= id]}))]
        {:total-update total-upate}))