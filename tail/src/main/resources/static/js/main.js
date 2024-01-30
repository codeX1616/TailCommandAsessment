'use strict';

var logs = document.querySelector('#logs');

const xhr = new XMLHttpRequest();
xhr.open("GET", "http://localhost:8080/tail?path=/Users/pratikjoshi/Desktop/deploy.txt&numLastLineToRead=10");
xhr.send();
xhr.responseType = "json";
xhr.onload = () => {
  if (xhr.readyState == 4 && xhr.status == 200) {
    const data = xhr.response;

    console.log(data);
    for (let i = 0; i < data.length; i++) {
       var node = document.createElement("li");
       node.innerHTML = data[i];
       logs.appendChild(node)
    }

    console.log(data.value);
  } else {
    console.log(`Error: ${xhr.status}`);
  }
};
