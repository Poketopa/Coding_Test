-- 코드를 입력하세요
SELECT 
    YEAR(S.SALES_DATE) AS YEAR,
    MONTH(S.SALES_DATE) AS MONTH,
    I.GENDER,
    COUNT(DISTINCT I.USER_ID) AS USERS
FROM 
    USER_INFO I
INNER JOIN 
    ONLINE_SALE S
ON 
    I.USER_ID = S.USER_ID
WHERE I.GENDER IS NOT NULL
GROUP BY YEAR(S.SALES_DATE), MONTH(S.SALES_DATE), I.GENDER

ORDER BY YEAR(S.SALES_DATE), MONTH(S.SALES_DATE), I.GENDER

