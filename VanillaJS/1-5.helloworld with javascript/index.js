//1-5
// alert('Im Working. Im JS. Im Beautiful. Im worth it');
// console.long('hello');

// 2-1
// function sayHello(name, age) {
//     console.log(`Hello ${name} you are ${age} years old`);
// }

// sayHello("Nico", 16);

//2-1
// const title = document.getElementById("title");
// const title = document.querySelector("#title");
// const tag = document.
// console.log(title);
// title.innerHTML = "Hi! From JS";

// console.log(title);
// console.dir(title);

// title.style.color = 'red'

// console.dir(document);
// document.title = "I own you now"
// function handleClick(){
//     if(title.style.color != "blue") title.style.color = "blue";
//     else title.style.color = "white";
// }
// function resizewindow(){

// }

// title.addEventListener("click", handleClick);
// title 이란 요소에 eventlistenr를 달아서, 클릭이란 이벤트가 발생할때마다 저 함수를 실행
const colors = ["#1abc9c", "#3498db", "#9b59b6", "#f39c12", "#e74c3c"];
////////////////////
//assignnment 3
// const title = document.querySelector("h1");

// const superEventHandler = {
//   mouseover: function () {
//     title.innerHTML = "Mouse is here!";
//     title.style.color = colors[0];
//   },
//   mouseout: function () {
//     title.innerHTML = "Mouse is gone!";
//     title.style.color = colors[1];
//   },
//    resize: function () {
//     title.innerHTML = "You just resized!";
//     title.style.color = colors[2];
//   },
//   mouseright: function(e){
//     title.innerHTML = "That was a right click!";
//     title.style.color = colors[4];
//   }
// };

// window.addEventListener("resize", superEventHandler.resize);
// title.addEventListener("mouseover", superEventHandler.mouseover);
// title.addEventListener("mouseout", superEventHandler.mouseout);
// window.addEventListener("contextmenu", superEventHandler.mouseright);




///////////////////////////////////////////////////////
/////////2.5
// const title = document.querySelector("#title");

// const BASE_COLOR = "rgb(255,13,200)";
// const OTHER_COLOR = "rgb(52,73,94)";

// function handleClick(){
//   const currentColor = title.style.color;
//   if(currentColor === BASE_COLOR){
//     title.style.color = OTHER_COLOR;
//   }else {
//     title.style.color = BASE_COLOR;
//   }
//   console.log(currentColor);
// }

// function init(){
//   title.style.color = BASE_COLOR;
//   title.addEventListener("mouseenter", handleClick);
// }

// init();

// function handleOffline(){
//   console.log("Good bye");
// }
// function handleOnline(){
//   console.log("Welcome back");
// }

// window.addEventListener("offline", handleOffline);
// window.addEventListener("online", handleOnline);

///////////////////////////////////
// const title = document.querySelector("#title");

// const Clicked_Class = "clicked";

// function handleClicked(){
  // const currentClass = title.className;
  // const hasClass = title.classList.contains(Clicked_Class);  //중요!
  // if(!hasClass){
  //   title.classList.add(Clicked_Class);   //기존 갖고있던 클래스에 클래스 더하기 
  // }else{
  //   title.classList.remove(Clicked_Class);
  // }
  //위 아래는 같은 펑션ㅇ이다
//   title.classList.toggle(Clicked_Class);
// }


//////////////

const body = document.querySelector("body");

function handleColor(){
  var w = document.documentElement.clientWidth;
  if(w < 700){
    body.className = "blue";
  }
  else if(w < 1000){
    body.className = "purple";
  }
  else{
    body.className = "yellow";
  }
  console.log(w);
}

function init(){
  window.addEventListener("resize", handleColor);
}

init();
