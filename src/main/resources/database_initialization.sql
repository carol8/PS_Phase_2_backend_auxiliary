USE baza_de_date_nationala_ps;

DELETE
FROM app_extended_donor_data
WHERE cnp = cnp;

INSERT INTO app_extended_donor_data
VALUES ("5020506204962", "O+", "Smoking", "2023-05-20"),
       ("5020506204964", "AB-", "Young age\nDiabetes", "2023-05-10"),
       ("5020506204965", "B+", "", "2023-05-30"),
       ("5020506204966", "A-", "Hip surgery ~3 months ago", "2023-04-15");
