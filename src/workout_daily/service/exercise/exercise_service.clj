(ns workout-daily.service.exercise.exercise-service
    (:require [workout-daily.dao.exercise.exercise-dao :as dao]
              [workout-daily.utils.date-utils :refer [convert-string-to-timestamp]]))

(defn get-all-workout-exercises [id-workout id-athlete]
    "Gets all exercises of workouts"
    (dao/get-all-workout-exercises id-workout id-athlete))

(defn get-workout-exercise [id-exercise id-workout id-athlete]
    "Gets workout's exercise by id"
    (dao/get-workout-exercise id-exercise id-workout id-athlete))

(defn add-exercise-to-workout [name creation_date set repetitions weight note id_workout]
    "Adds new workout to exercise"
    (dao/add-exercise-to-workout name (convert-string-to-timestamp creation_date)
                                 set repetitions weight note id_workout))

(defn delete-exercise [id]
    "Deletes a exercise by id"
    (dao/delete-exercise id))

(defn update-exercise [id name]
    "Update just name of exercise by id"
    (dao/update-exercise id name))