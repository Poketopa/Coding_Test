SELECT
    A.FOOD_TYPE,
    A.REST_ID,
    A.REST_NAME,
    A.FAVORITES
FROM
    REST_INFO A
JOIN
    (SELECT
        FOOD_TYPE,
        MAX(FAVORITES) AS BMAX
     FROM
        REST_INFO
     GROUP BY 
        FOOD_TYPE
        ) B
ON 
    A.FAVORITES = B.BMAX AND A.FOOD_TYPE = B.FOOD_TYPE

ORDER BY
    A.FOOD_TYPE DESC