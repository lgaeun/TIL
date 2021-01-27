const clockContainer = document.querySelector(".js-clock"),
      clockTitle = clockContainer.querySelector("h1");

function getTime(){
    const date = new Date();
    const minutes = date.getMinutes();
    const hours = date.getHours();
    const seconds = date.getSeconds();
    clockTitle.innerText = `${hours < 10 ? `0${hours}` : hours}:${
        minutes < 10 ? `0${minutes}` : minutes}:${
        seconds < 10 ? `0${seconds}` : seconds
    }`; // teneraray operator 사용해서 다 두자리 수로 표시 ex) 0->09로 표시
    

}

function init() {
    getTime();  //get the time
    setInterval(getTime, 1000); //1초 마다 시간 가져오기
}

init();