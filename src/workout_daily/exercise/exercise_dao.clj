(ns workout-daily.exercise.exercise-dao
    (:require [workout-daily.database.database]
            [korma.core :refer :all])
    (:import java.text.SimpleDateFormat)
    (:import java.sql.Timestamp))

(defentity exercise)
(defentity workout)
(defentity athlete)

(defn get-all-workout-exercises [id-workout id-athlete]
    "Gets all exercises of workouts in Exercise table"
    (select exercise
        (join workout (= :workout.id :exercise.id_workout))
        (join athlete (= :athlete.id :workout.id_athlete))
        (where (and (= :athlete.id id-athlete) (= :exercise.id_workout id-workout)))))

(defn get-workout-exercise [id-exercise id-workout id-athlete]
    "Gets workout's exercise by id"
    (select exercise
        (join workout (= :workout.id :exercise.id_workout))
        (join athlete (= :athlete.id :workout.id_athlete))
        (where (and (= :athlete.id id-athlete)
            (= :exercise.id_workout id-workout) (= :exercise.id id-exercise)))))

(defn convert-string-to-timestamp [str_date]
    "Convert string in format yyyy-mm-dd to Java timestamp"
    (let [simple-date-format (SimpleDateFormat. "yyyy-MM-dd")]
        (Timestamp. (.getTime (.parse simple-date-format str_date)))))

(defn add-exercise-to-workout [name creation_date set repetitions weight note id_workout]
    "Adds new workout to exercise with values: name, creation_date, set, repetitions, weight, note, id_workout"
    (let [value-default {:name name :set set :repetitions repetitions
                         :weight weight :note note :id_workout id_workout}
          value-to-insert (if (nil? creation_date) value-default
                            (conj value-default 
                                {:creation_date (convert-string-to-timestamp creation_date)}))]
        (insert exercise
            (values value-to-insert))))

(defn delete-exercise [id]
    "Deletes a exercise by id"
    (delete exercise
        (where {:id id}))
    {:status 200})

(defn update-exercise [id name]
    "Update just name of exercise by id"
    (let [total-upate
            (update exercise
                (set-fields {:name name})
                (where {:id [= id]}))]
        {:total-update total-upate}))