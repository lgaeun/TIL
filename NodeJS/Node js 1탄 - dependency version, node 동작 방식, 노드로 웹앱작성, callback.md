# ^와 ~ : 시멘틱 버전(semantic versioning)

- Semantic version이란? 디펜던시에서 볼 수 있는 버전의 표현 방식
- ‘^’가 dependency 앞에 쓰였을 때

    : 호환가능한 최신 기능의 버전으로 업데이트 한다.

    : 예를들어) ^16.8.6 → 16. * . *버전을 가져올 수 있는 것! 단, 17.으로 시작하는 버전은 가져올 수 없다

- ‘~’가 dependency 앞에 쓰였을 때

    : 버그가 픽스된 최신 버전으로 업데이트 한다

    : 즉, ^16.8.6 버전의 기준으로 16.8. * 을 가져올 수 있다

# Node.js의 동작

- 노드js는 자바스크립트와 event loop로 만들어졌다. 즉, 단일 스레드인 메인 스레드가 노드JS 백드라운드 워커에게 작업을 할당하고, 각 워커는 해당 이벤트로 노드JS 콜백에 이벤트를 전달한다. 메인스레드는 그 동안 다른 요청을 처리한다
- 콜백(callback): 어떠한 이벤트가 발생했을 때, 다른 함수의 인자로 전달되는 함수
- 메인 스레드(자바스크립트 내부에 우리가 작성한 코드)는 한 번에 하나씩 처리하고  워커는 병렬적으로 일어난다.
- 따라서, 싱글스레드 시스템 사용 시: 메인 스레드가 다른 일을 할 수 있게 너무 많은 부하를 거는 작업을 피하는 게 좋다.

# 노드로 웹앱 작성하기

노드로 웹앱을 작성한다는 것 = 노드에 특정 이벤트가 발생했을 때, 이벤트를 처리하는 이벤트핸들러를 작성하는 것

1. 작업 폴더를 새로 만들고 npm init → package.json 이 생성된다
2. server.js라는 파일을 만들고, 그 안에 다음과 같은 코드를 작성한다

```jsx
// server.js
const http = require('http'),

server = http.createServer((request, response) => {
    response.writeHead(200, {'Content-Type':'text/plain'});
    response.write('Hello World');
    response.end();
});

server.listen(3000, () => {
    console.log('Node Server Created at port 3000');
});
```

위 코드에 대한 설명을 덧붙이자면 다음과 같다.

1. http 모듈 import: http모듈을 require함수로 불러와 http라는 객체에 저장
2. 서버 객체 생성: http모듈의 createServer()함수로 서버 객체를 생성하고, 인자로 콜백함수를 넘긴다
3. 우리가 따로 이벤트 핸들러를 생성할 필요 없이, 노드가 request 이벤트 핸들러를 추가한다.
4.  이 콜백함수는 2개의 객체 request, response를 인자로 받는다.
5. response.wirteHead(): 서버 응당 헤더에 상태코드(200), 콘텐츠타입을 추가
6. response.write(): 웹페이지에 무언가를 적는다
7. response.end(): 서버에 대한 응답 닫는다
8. 서버는 3000 번 포트를 계속 듣고 있는다.

# 콜백

- 노드는 단일스레드 이벤트 환경이다. 즉, 모든 것들이 이벤트를 통해 응답한다.
- 콜백은 이벤트가 발생했을 때, 다른 함수의 인자로 전달되는 함수이다.
- 콜백은 변수의 형태로 전달될 수도 있고, 다른 함수로 전달될 수 도 있다.

```jsx
// server.js
const http = require('http'),
      
makeServer = function (request, response) {
	response.writeHead(200, {'Content-Type':'text/plain'});
	response.write('Hello world');
	response.end();
},
      
server = http.createServer(makeServer);

server.listen(3000, () => {
	console.log('Node server created at port 3000');
});
```

자바스크립트에서 함수는 1급 객체이기 때문에, makeServer는 콜백이다.