'use strict';

const people = require("./people.json");

// Aufgabe 01: Finde in der Datei people.json alle Personen, die "rob" im first_name haben. Gib von denen die IP-Adressen aus.
const findRob = people.filter((person) => person.first_name.includes('Rob'));
findRob.map((person) => console.log(person.ip_address));


// Aufgabe 03: Was ist die email-adresse der Person mit der IP-Adresse 75.221.164.181
const found = people.find((ipAdress) => ipAdress.ip_address == "75.221.164.181");
