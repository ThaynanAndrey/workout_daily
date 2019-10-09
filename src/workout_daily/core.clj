(ns workout-daily.core
  (:require [compojure.core :refer :all]
            [ring.middleware.json :as json]
            [workout-daily.athlete.athlete-handler :refer [athlete-handler]]
            [workout-daily.workout.workout-handler :refer [workout-handler]]
            [workout-daily.exercise.exercise-handler :refer [exercise-handler]]))

(def app
     (-> (routes athlete-handler
                 workout-handler
                 exercise-handler)
          (json/wrap-json-params)
          (json/wrap-json-response)))