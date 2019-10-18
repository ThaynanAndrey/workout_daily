(ns workout-daily.config.database.database
  (:require [korma.db :as korma]))

(def db-connection-info 
    (korma/postgres 
        {:host "localhost"
         :port "5432"
         :db "workout_daily"
         :user "app_workout_daily"
         :password "workout"
         :delimiters ""}))

; set up korma
(korma/defdb db db-connection-info)