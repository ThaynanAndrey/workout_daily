(ns workout-daily.athlete.athlete-handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [workout-daily.athlete.athlete-dao :refer :all]))

(defroutes athlete-routes
  (GET "/api/athletes" []
       (response (get-athletes)))

  (GET "/api/athletes/:id" [id]
       (response (get-athlete (Integer/parseInt id))))

  (POST "/api/athletes" {:keys [params]}
    (let [{:keys [name age height weight]} params]
      (response (add-athlete name age height weight))))

  (PUT "/api/athletes/:id" [id name]
       (response (update-athlete (Integer/parseInt id) name)))

  (DELETE "/api/athletes/:id" [id]
        (response (delete-athlete (Integer/parseInt id))))

  (route/resources "/")

  (route/not-found "Not Found"))


(def athlete-handler
    (-> (handler/api athlete-routes)
        (json/wrap-json-params)
        (json/wrap-json-response)))