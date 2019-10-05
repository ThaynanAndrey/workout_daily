(ns workout-daily.core
  (:require [compojure.core :refer :all]
     [compojure.handler :as handler]
     [compojure.route :as route]
     [ring.middleware.json :as json]
     [ring.util.response :refer [response]]
     [workout-daily.user.user-dao :refer :all]))

(defroutes user-routes
  (GET "/api/users" []
       (response (get-users)))
  (GET "/api/users/:id" [id]
       (response (get-user (Integer/parseInt id))))
  (POST "/api/users" {:keys [params]}
    (let [{:keys [name age height weight]} params]
      (response (add-user name age height weight))))
  (PUT "/api/users/:id" [id name]
       (response (update-user (Integer/parseInt id) name)))
  (DELETE "/api/users/:id" [id]
        (response (delete-user (Integer/parseInt id))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api user-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))