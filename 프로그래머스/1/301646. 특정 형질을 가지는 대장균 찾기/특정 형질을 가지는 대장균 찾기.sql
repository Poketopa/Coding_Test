SELECT 
    COUNT(ID) AS COUNT
FROM
    ECOLI_DATA
WHERE
    (GENOTYPE & 2 = 0) AND ((GENOTYPE & 1 = 1) or (GENOTYPE & 4) = 4)