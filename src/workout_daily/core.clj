(ns workout-daily.core
  (:require [compojure.core :refer :all]
     [workout-daily.athlete.athlete-handler :refer [athlete-handler]]))

(def app
     (routes athlete-handler))