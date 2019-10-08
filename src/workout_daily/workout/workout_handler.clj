(ns workout-daily.workout.workout-handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [workout-daily.workout.workout-dao :refer :all]))

(defroutes workout-routes
    (GET "/api/athletes/:id-athlete/workouts" [id-athlete]
        (response (get-all-athlete-workouts (Integer/parseInt id-athlete))))
    
    (GET "/api/athletes/:id-athlete/workouts/:id-workout" [id-athlete id-workout]
        (response (get-athlete-workout (Integer/parseInt id-workout) (Integer/parseInt id-athlete))))

    (POST "/api/athletes/:id-athlete/workouts" {:keys [params]}
        (let [{:keys [name id-athlete creation_date]} params]
            (response (add-workout-to-athlete name (Integer/parseInt id-athlete) creation_date))))
            
    (DELETE "/api/athletes/:id-athlete/workouts/:id-workout" [id-workout]
        (response (delete-workout (Integer/parseInt id-workout))))
        
    (PUT "/api/athletes/:id-athlete/workouts/:id-workout" [id-workout name]
       (response (update-workout (Integer/parseInt id-workout) name))))

(def workout-handler
    (handler/api workout-routes))