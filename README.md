Kailua CarRental System
Oversigt
Kailua CarRental System er en Java-baseret applikation designet til at administrere biludlejning. 
Den inkluderer funktioner til at håndtere kunder, biler, biltyper og udlejninger. 
Systemet interagerer med en MySQL-database for at gemme og hente data.

1. Klon Repository

2. Opret en database kaldet carRental
   CREATE TABLE city (
    zip VARCHAR(40) PRIMARY KEY,
    city VARCHAR(50) NOT NULL
);

CREATE TABLE customer (
    driverLicenseNumber VARCHAR(100) PRIMARY KEY, 
    fName VARCHAR(50) NOT NULL,
lName VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL,
    zip VARCHAR(40),
    mobilePhone VARCHAR(40) NOT NULL, 
    email VARCHAR(60) NOT NULL,
    driverSinceDate DATE NOT NULL,
    FOREIGN KEY(zip) REFERENCES city(zip) ON DELETE SET NULL
);

CREATE TABLE car_type (
    carType_id INT AUTO_INCREMENT PRIMARY KEY, 
    typeName VARCHAR(100) NOT NULL,
    automaticGear BOOLEAN NOT NULL,
    airCondition BOOLEAN NOT NULL,
    cruiseControl BOOLEAN NOT NULL,
    leatherSeats BOOLEAN NOT NULL,
    engineSize INT NOT NULL,
    horsePower INT NOT NULL,
    seats INT NOT NULL
);



CREATE TABLE car (
    registrationNumber VARCHAR(50) PRIMARY KEY,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    fuelType VARCHAR(100) NOT NULL, 
    firstRegistrationDate DATE NOT NULL,
    odometer INT NOT NULL,
    carType_id INT, 
    FOREIGN KEY(carType_id) REFERENCES car_type(carType_id) ON DELETE SET NULL
);

CREATE TABLE rental (
    rental_id INT AUTO_INCREMENT PRIMARY KEY,
    fromDateTime DATETIME NOT NULL,
    toDateTime DATETIME NOT NULL,
    maxKm INT NOT NULL,
    startOdometer INT NOT NULL,
    registrationNumber VARCHAR(50),
    driverLicenseNumber VARCHAR(50),
    FOREIGN KEY(registrationNumber) REFERENCES car(registrationNumber),
    FOREIGN KEY(driverLicenseNumber) REFERENCES customer(driverLicenseNumber) ON DELETE CASCADE
);

3. Opdater Database klassen med dine SQL database-oplysninger.
   private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/carRental";
private static final String USERNAME = "your-username";
private static final String PASSWORD = "your-password";
4. 
Programmet starter med en loading screen for en sjov visuel effekt.

Hovedmenu:
Hovedmenuen giver muligheder for at administrere kunder, udlejninger, biler og biltyper.
Vælg en mulighed ved at indtaste det tilsvarende nummer.

Administrer Kunder:
Tilføj Kunde: Indtast kundedetaljer inklusive kørekortnummer, navn, adresse, postnummer, telefonnummer, e-mail og kørekort siden dato.
Se Kunde: Indtast kørekortnummeret for at se kundedetaljer.
Opdater Kunde: Indtast kørekortnummeret og opdater de ønskede felter.
Slet Kunde: Indtast kørekortnummeret for at slette kunden.
Tilføj By: Indtast postnummer og bynavn for at tilføje en ny by.

Administrer Udlejninger:
Tilføj Udlejning: Indtast udlejningsdetaljer inklusive startdato, slutdato, maksimale kilometer, registreringsnummer og kørekortnummer.
Se Udlejning: Indtast udlejnings-ID for at se udlejningsdetaljer.
Opdater Udlejning: Indtast udlejnings-ID og opdater de ønskede felter.
Slet Udlejning: Indtast udlejnings-ID for at slette udlejningen.

Administrer Biler:

Tilføj Bil: Indtast bildetaljer inklusive registreringsnummer, mærke, model, brændstoftype, første registreringsdato, kilometertæller og biltype-ID.
Se Bil: Indtast registreringsnummeret for at se bildetaljer.
Opdater Bil Kilometertæller: Indtast registreringsnummeret og den nye kilometertællerværdi.
Slet Bil: Indtast registreringsnummeret for at slette bilen.
Administrer Biltyper:

Tilføj Biltype: Indtast biltypedetaljer inklusive typenavn, gear type, aircondition, fartpilot, lædersæder, motorstørrelse, hestekræfter og antal sæder.
Se Biltype: Indtast biltype-ID for at se biltypedetaljer.
Opdater Biltype: Indtast biltype-ID og opdater de ønskede felter.
Slet Biltype: Indtast biltype-ID for at slette biltypen.
Afslut:

Vælg afslutningsmuligheden for at lukke programmet og afbryde forbindelsen til databasen.
