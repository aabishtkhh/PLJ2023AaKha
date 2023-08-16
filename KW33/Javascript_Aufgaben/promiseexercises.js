// Exercise 1: Basic Promise Creation
// Create a simple promise that resolves after a certain delay. Log a message when the promise is resolved.

const firstPromise = new Promise(function (resolve) {
    setTimeout(function () {
        resolve('The Promise was resolved');
    }, 100);
});

firstPromise.then(function (value) {
    console.log(value)
});

// Exercise 2: Chaining Promises
// Create a chain of promises that simulates ordering food. Order a burger, then order fries after the burger is delivered. Log messages at each step.

const secondPromise = new Promise(function (resolve) {
    setTimeout(() => resolve, 200);  //initial promise resolves in 2 second

}).then(function (food) {
    console.log('Order Burger') // order burger

}).then(function (food) {
    console.log('Burger delivered') // burger delivered

}).then(function (food) {
    console.log('Order Fries') // order fries 

});

// Exercise 3: Error Handling
// Create a promise that rejects with an error message if a certain condition is not met. Handle the error using the catch method.

const thirdPromise = new Promise(function (resolve, reject) { // Executor function
    let check = "Hygraph";

    if (check !== "Hygraph") {
        resolve("Success: The promise has successfully resolved!");
    } else {
        reject("Failure: The promise has failed!");
    }
});

thirdPromise.then(
    (result) => {
        console.log(result); // Prints "Success: The promise has successfully resolved!"
    },
    (error) => {
        console.log(error);
    }
);

// Exercise 4: Promise.all
// Create multiple promises that simulate fetching data from different sources. Use Promise.all to handle them concurrently and log the results when all promises are resolved.

const fourthPromise01 = new Promise(function (resolve) {
    setTimeout(function () {
        resolve('Fourth Promise first try');
    }, 0);
});

const fourthPromise02 = new Promise(function (resolve) {
    setTimeout(function () {
        resolve('Fourth Promise second try');
    }, 0);
});

const fourthPromise03 = new Promise(function (resolve) {
    setTimeout(function () {
        resolve('Fourth Promise third try');
    }, 0);
});

Promise.all([fourthPromise01, fourthPromise02, fourthPromise03])
.then((values) => {
    console.log(values);
  })
  .catch(error => console.log(`Error in promises ${error}`));
  
// Exercise 5: Promise.race
// Create multiple promises with different delay times. Use Promise.race to determine which promise resolves first and log its result.

let fifthPromise1 = new Promise(resolve => setTimeout(() => {
    console.log("Fifth Promise 1 resolved");
    resolve(1)
}, 1000));

let fifthPromise2 = new Promise(resolve => setTimeout(() => {
    console.log("Fifth Promise 2 resolved");
    resolve(2)
}, 500));
let fifthPromise3 = new Promise(resolve => setTimeout(() => {
    console.log("Fifth Promise 3 resolved");
    resolve(3)
}, 1500));

Promise.race([
    fifthPromise1,
    fifthPromise2,
    fifthPromise3
]).then((result) => {
    console.log("All promises are done")
    console.log(result);
});
