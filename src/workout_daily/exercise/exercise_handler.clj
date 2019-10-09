(ns workout-daily.exercise.exercise-handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [workout-daily.exercise.exercise-dao :refer :all]))

(defroutes exercise-routes
    (GET "/api/athletes/:id-athlete/workouts/:id-workout/exercises" [id-athlete id-workout]
        (response (get-all-workout-exercises (Integer/parseInt id-workout) (Integer/parseInt id-athlete))))
    
    (GET "/api/athletes/:id-athlete/workouts/:id-workout/exercises/:id-exercise" [id-athlete id-workout id-exercise]
        (response (get-workout-exercise (Integer/parseInt id-exercise)
            (Integer/parseInt id-workout) (Integer/parseInt id-athlete))))

    (POST "/api/athletes/:id-athlete/workouts/:id-workout/exercises" {:keys [params]}
        (let [{:keys [name creation_date set repetitions weight note id-workout]} params]
            (response 
                (add-exercise-to-workout name creation_date set repetitions weight note (Integer/parseInt id-workout)))))
            
    (DELETE "/api/athletes/:id-athlete/workouts/:id-workout/exercises/:id-exercise" [id-exercise]
        (response (delete-exercise (Integer/parseInt id-exercise))))
        
    (PUT "/api/athletes/:id-athlete/workouts/:id-workout/exercises/:id-exercise" [id-exercise name]
       (response (update-exercise (Integer/parseInt id-exercise) name))))

(def exercise-handler
    (handler/api exercise-routes))