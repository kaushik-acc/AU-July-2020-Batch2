SELECT D.DNAME,DEP.DEPNAME,COUNT(P.PNAME) FROM  PATIENT P RIGHT JOIN DOCTOR D ON P.DID=D.DID JOIN DEPARTMENT DEP ON  D.DEPID=DEP.DEPID GROUP BY DNAME,DEPNAME;
