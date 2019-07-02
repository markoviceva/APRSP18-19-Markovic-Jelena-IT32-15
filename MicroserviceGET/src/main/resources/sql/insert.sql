INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES(nextval('fakultet_seq'), 'Fakultet tehnickih nauka', 'Novi Sad');
INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES(nextval('fakultet_seq'), 'Tehnoloski fakultet', 'Novi Sad');
INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES(nextval('fakultet_seq'), 'Pravni fakultet', 'Novi Sad');
INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES(nextval('fakultet_seq'), 'Prirodno-Matematicki fakultet', 'Novi Sad');


INSERT INTO "status"("id", "naziv", "oznaka")
VALUES(nextval('status_seq'), 'Student prve godine', 'SPG');
INSERT INTO "status"("id", "naziv", "oznaka")
VALUES(nextval('status_seq'), 'Student druge godine', 'SDG');
INSERT INTO "status"("id", "naziv", "oznaka")
VALUES(nextval('status_seq'), 'Student trece godine', 'STG');
INSERT INTO "status"("id", "naziv", "oznaka")
VALUES(nextval('status_seq'), 'Student cetvrte godine', 'ScG');
INSERT INTO "status"("id", "naziv", "oznaka")
VALUES(nextval('status_seq'), 'Apsolvent', 'APS');
INSERT INTO "status"("id", "naziv", "oznaka")
VALUES(nextval('status_seq'), 'Master studije', 'MSC');


INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Biologija', 'BIO', 4);
INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Geografija', 'GEO', 4);
INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Turizam', 'TUR', 4);
INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Matematika', 'MAT', 4);
INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Informatika', 'IT', 4);

INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Industrijsko inzenjerstvo i menadzment', 'IIS', 1);
INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Gradjevina', 'GRID', 1);
INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Elektrotehnika', 'E', 1);

INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Nafta', 'NAF', 2);
INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Prehrambena tehnologija', 'PRT', 2);
INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Kvalitet', 'KV', 2);
INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Materijali', 'MAT', 2);

INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Advokatura', 'ADV', 3);
INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES(nextval('departman_seq'), 'Sudstvo', 'SUD', 3);

INSERT INTO "student"("id", "br_indexa", "ime", "prezime", "departman", "status")
VALUES (nextval('student_seq'), 'IT32/15', 'Jelena', 'Markovic', 6, 4);
INSERT INTO "student"("id", "br_indexa", "ime", "prezime", "departman", "status")
VALUES (nextval('student_seq'), 'IT38/15', 'Milica', 'Pavlovic', 6, 4);
INSERT INTO "student"("id", "br_indexa", "ime", "prezime", "departman", "status")
VALUES (nextval('student_seq'), 'IT59/16', 'Aleksandra', 'Bakovic', 6, 3);
INSERT INTO "student"("id", "br_indexa", "ime", "prezime", "departman", "status")
VALUES (nextval('student_seq'), 'IT32/17', 'Sara', 'Kijanovic', 6, 4);
INSERT INTO "student"("id", "br_indexa", "ime", "prezime", "departman", "status")
VALUES (nextval('student_seq'), 'IT34/15', 'Jovana', 'Markovic', 1, 2);
INSERT INTO "student"("id", "br_indexa", "ime", "prezime", "departman", "status")
VALUES (nextval('student_seq'), 'IT32/15', 'Sanja', 'Tomic', 1, 4);
INSERT INTO "student"("id", "br_indexa", "ime", "prezime", "departman", "status")
VALUES (nextval('student_seq'), 'PT32/18', 'Hristina', 'Radovic', 10, 1);
INSERT INTO "student"("id", "br_indexa", "ime", "prezime", "departman", "status")
VALUES (nextval('student_seq'), 'PV32/17', 'Nevena', 'Novosel', 14, 2);
