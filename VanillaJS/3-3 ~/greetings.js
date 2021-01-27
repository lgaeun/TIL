const form = document.querySelector(".js-form"), //gets the first one
  input = form.querySelector("input"),
  greeting = document.querySelector(".js-greetings");

const USER_LS = "currentUser",
  SHOWING_ON = "showing";

function paintGreeting(text) {
  form.classList.remove(SHOWING_ON); //paing greetying하려면 form을 숨겨야 함
  greeting.classList.add(SHOWING_ON);
  greeting.innerText = `Hello ${text}`;
}

function saveName(text) {
  localStorage.setItem(USER_LS, text);
}
//preventDafault of default behavior(=browser's submit)
function handleSubmit(event) {
  event.preventDefault();
  const currentValue = input.value;
  paintGreeting(currentValue);
  saveName(currentValue);
}

//form을 제출하면(submit) document는 어디론가 보내려고함(refresh)
function askForName() {
  form.classList.add(SHOWING_ON);
  form.addEventListener("submit", handleSubmit);
}

function loadName() {
  const currentUser = localStorage.getItem(USER_LS);
  if (currentUser === null) {
    askForName();
  } else {
    paintGreeting(currentUser);
  }
}
function init() {
  loadName();
}

init();
