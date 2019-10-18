(ns workout-daily.service.workout.workout-service
    (:require [workout-daily.dao.workout.workout-dao :as dao]
              [workout-daily.utils.date-utils :refer [convert-string-to-timestamp]]))

(defn get-all-athlete-workouts [id-athlete]
    "Gets all workouts of athlete"
    (dao/get-all-athlete-workouts id-athlete))

(defn get-athlete-workout [id-workout id-athlete]
    "Gets workout of athlete by id"
    (dao/get-athlete-workout id-workout id-athlete))

(defn add-workout-to-athlete [name id_athlete creation_date]
    "Adds new workout to athlete with values: name id_athlete creation_date"
    (dao/add-workout-to-athlete name id_athlete (convert-string-to-timestamp creation_date)))

(defn delete-workout [id]
    "Deletes a workout by id"
    (dao/delete-workout id))

(defn update-workout [id name]
    "Update just name of workout by id"
    (dao/update-workout id name))