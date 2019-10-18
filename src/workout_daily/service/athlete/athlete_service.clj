(ns workout-daily.service.athlete.athlete-service
  (:require [workout-daily.dao.athlete.athlete-dao :as dao]))

(defn get-athletes []
  "Gets all athletes"
  (dao/get-athletes))

(defn get-athlete [id]
  "Gets athlete by id"
  (dao/get-athlete id))

(defn add-athlete [name age height weight]
  "Adds new athlete in database"
  (dao/add-athlete name age height weight))

(defn delete-athlete [id]
  "Deletes a athlete by id"
  (dao/delete-athlete id))

(defn update-athlete [id name]
  "Update just name of athlete by id"
  (dao/update-athlete id name))