/* Aufgabe 05/6: 
Erstelle ein HTML-Dokument mit einer unordered list von 20 Einträgen (früchte, Städte..etc)
Allerdings müssen die <li> Einträge über ein Javascript erstellt werden. 
Das Document selbst hat nur ein Header und ein Body.

Im Anschluss muss jeder Eintrag mittels neuem Script eine zufällige Farbe gegeben werden.

Im Anschluss muss diese Liste noch sortiert werden.*/
const foods = [
    "Coffee",
    "Tea",
    "Milk",
    "Chai",
    "Lemon Juice",
    "Juice",
    "Strawberry Milk",
    "Water",
    "Orange Juice",
    "Chocolate Milk",
    "Apple",
    "Banana",
    "Orange",
    "Chai Tea",
    "Lemon",
    "Apple Juice",
    "Strawbery",
    "Dragon Fruit",
    "Ice Lemonade",
    "Star Fruit",
  ];

  foods.sort();

  const creatingUL = document.getElementById('creatingUL');
  
  const arrayToLi = foods.map((food) => {
    const li = document.createElement('li');
    li.textContent = food;
    const randomColor = Math.floor(Math.random()*16777215).toString(16);
    li.style.color = "#" + randomColor;

    creatingUL.appendChild(li);
  });

  console.log("Did the List work ", Boolean(arrayToLi));

