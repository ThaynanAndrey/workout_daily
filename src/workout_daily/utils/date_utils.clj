(ns workout-daily.utils.date-utils
    (:import java.text.SimpleDateFormat)
    (:import java.sql.Timestamp))

(defn convert-string-to-timestamp [str_date]
    "Convert string in format yyyy-mm-dd to Java timestamp"
    (let [simple-date-format (SimpleDateFormat. "yyyy-MM-dd")]
        (if (nil? str_date) nil (Timestamp. (.getTime (.parse simple-date-format str_date))))))