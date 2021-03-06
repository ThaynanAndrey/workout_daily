(ns workout-daily.handler.athlete.athlete-handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [workout-daily.service.athlete.athlete-service :as athlete-service]))

(defroutes athlete-routes
  (GET "/api/athletes" []
       (response (athlete-service/get-athletes)))

  (GET "/api/athletes/:id" [id]
       (response (athlete-service/get-athlete (Integer/parseInt id))))

  (POST "/api/athletes" {:keys [params]}
    (let [{:keys [name age height weight]} params]
      (response (athlete-service/add-athlete name age height weight))))

  (PUT "/api/athletes/:id" [id name]
       (response (athlete-service/update-athlete (Integer/parseInt id) name)))

  (DELETE "/api/athletes/:id" [id]
        (response (athlete-service/delete-athlete (Integer/parseInt id)))))

(def athlete-handler 
     (handler/api athlete-routes))