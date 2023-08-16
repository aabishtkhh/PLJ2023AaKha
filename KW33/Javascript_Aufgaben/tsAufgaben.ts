// Aufgabe 01
let z : number = 100;

function addToZ (x: number , y:number) {
    return x + y + z;
}

// Aufgabe 02
enum Status {
 done, 
 pending, 
 active, 
 archived
}

// Aufgabe 03
interface User {
    id: number,
    firstName?: string,
    lastName?: string,
    phoneNumber?: string,
    report: Status 
}

// Aufgabe 04
let word : string;
var number : number;
let dec : boolean;
let numberArray : number[];

//..

// Aufgabe 05
interface Person {
    fullName: string,
    age: number,
    adress?: string 
}

let allPeople : Person[] = [
    {"fullName":"Mead", "age": 2},
    {"fullName":"Xandra", "age": 18, "adress" : "Bächelweg 3, 8156 Oberhasli"}
]

function filterPersonAboveCertainAge (people : Person[], adultAge: number){
    const adults = people.filter(person => person.age >= adultAge);
     return adults.map(person => person.fullName);
}

const adultsAboveAge = filterPersonAboveCertainAge(allPeople, 18);
console.log("Adults above 18: ", adultsAboveAge)

// Aufgabe 06
class Form {
    constructor() {}

    calArea(): number {
        return 0; 
    }

    calScope(): number {
        return 0; 
    }
}

class Rectangle extends Form {
    breite: number;
    hoehe: number;

    constructor(breite: number, hoehe: number) {
        super();
        this.breite = breite;
        this.hoehe = hoehe;
    }

    calArea(): number {
        return this.breite * this.hoehe;
    }

    calScope(): number {
        return 2 * (this.breite + this.hoehe);
    }
}

class Circle extends Form {
    radius: number;

    constructor(radius: number) {
        super();
        this.radius = radius;
    }

    calArea(): number {
        return 3.14 * this.radius * this.radius;
    }

    calScope(): number {
        return 3.14 * 2 * this.radius;
    }
}

const rec = new Rectangle(5, 7);
console.log("Rectangle Area: ", rec.calArea());
console.log("Rectangle Scope: ", rec.calScope());

const circ = new Circle(2.5);
console.log("Circle Area: ", circ.calArea());
console.log("Circle Scope: ", circ.calScope());

// Aufgabe 07

var elementsOfArray07 :  string[] = [
    "Z", "U", "B", "I", "F"
]; 

function sortingAnyArraysAufgabe07 <Type> (anyArray: Type[], callBackFunction : (a : Type, b : Type) => number){ 
    //callback: callBackFunction : (a : Type, b : Type) => number, generic type: <>
    const sortedArray = anyArray.sort(callBackFunction);
    return sortedArray;
}

function sortAsc07 (a : string, b : string) : number { 
    if (a > b) {
        return 1;
    } else if (a < b) {
        return -1;
    } else {
        return 0;
    }
}

const sortingTryout = sortingAnyArraysAufgabe07 <string> (elementsOfArray07, (sortAsc07));
console.log("Sorting Result: ", sortingTryout);

// Aufgabe 08

async function retrieveData () { // returns a Promise to retrieve data
    let response = await fetch("https://zenquotes.io/api/random");
    let data = await response.text();
    return data;
} 

function processData () { // processes the retrieved data and logs it to the console.
    retrieveData()
    .then(quote => console.log(quote))
    .catch(error => {
        throw new Error("There has been a problem with retrieving data");
    });
}

processData();