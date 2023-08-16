'use strict';

const people = require("./people.json");

// Aufgabe 01: Finde in der Datei people.json alle Personen, die "rob" im first_name haben. Gib von denen die IP-Adressen aus.
const findRob = people.filter((person) => person.first_name.includes('Rob'));
findRob.map((person) => console.log("Loesungen: 010X: ", person.ip_address));

//Aufgabe 02: 1. Teilaufgabe: Sind alle firstnames kürzer als 20 Zeichen? (Ausgabe true/false) 
const findPerson21 = people.find(person => person.first_name.length < 20);
console.log("Loesungen: 0201: ", Boolean(findPerson21));

//Aufgabe 02: 2. Teilaufgabe: Sind alle firstnames kürzer als 12 Zeichen? (Ausgabe true/false) 
const findPerson22 = people.find(person => person.first_name.length < 12);
console.log("Loesungen: 0202: ", Boolean(findPerson22));

// Aufgabe 03: Was ist die email-adresse der Person mit der IP-Adresse 75.221.164.181
const foundPerson = people.find((person) => person.ip_address === "75.221.164.181");
console.log("Loesungen: 0300: ", foundPerson.email);

// Aufgabe 04: 1. Teilaufgabe: Gibt es jemanden mit dem last_name "Free"? (Ausgabe true/false)
const findPerson41 = people.find(person => person.last_name.includes('Free')); // const won't be reassigned
console.log("Loesungen: 0401: ", Boolean(findPerson41));

// Aufgabe 04: 2. Teilaufgabe: Gibt es jemanden mit dem first_name "Gianluca"? (Ausgabe true/false)
const findPerson42 = people.find(person => person.first_name.includes('Gianluca'));
console.log("Loesungen: 0401: ", Boolean(findPerson42));

// Aufgabe 04: 3. Teilaufgabe:Gibt es jemanden mit dem first_name "Buddy"? (Ausgabe true/false)
const findPerson43 = people.find(person => person.first_name.includes('Buddy'));
console.log("Loesungen: 0403: ", Boolean(findPerson43));


