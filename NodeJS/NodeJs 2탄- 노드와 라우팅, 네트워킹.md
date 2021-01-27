# 노드의 라우팅

- 라우팅: 서버는 많은 파일을 저장한다. 브라우저는 요청 시에 브라우저가 무엇을 찾는지 알려준다. 서버는 그들이 요청한 파일을 줌으로써 응답하는데, 이것을 라우팅이라고 한다. 즉, 요청에 대한 알맞은 응답. 브라우저로 따지면 알맞은 페이지(=알맞는 페이지 경로)를 주는 것이다!
- 노드js에서는 수동으로 라우터를 정의해야 한. 이때 url 이라는 새로운 모듈을 이용한다ㅁ.
- url.parse(request.url).pathname 입력: url 모듈은 우리에게 pathname 부분을 준다.

[]()

# Express를 이용해 라우팅하기

- Express 프레임워크: 노드js 프레임워크로 웹앱을 빌드하거나 API를 만들 때 사용, 라우팅을 간편하게 할 수 있다.

```jsx
npm install express --save
```

```jsx
const express = require('express'),
      server = express();

server.set('port', process.env.PORT || 3000);

//Basic routes
server.get('/', (request, response) => {
	response.send('Home page');  
});

server.get('/about', (request, response) => {
	response.send('About page');
});

// Express error handling middleware
server.use((request, response) => {
	response.type('text/plain');
	response.status(505);
	response.send('Error page');
});

// Binding to a port
server.listen(3000, () => {
	console.log('Express server started at port 3000');  
});
```

- 익스프레스에서 라우팅 패턴:

- server.set() 메소드를 이용해 포트 작성. process.env.PORT는 앱이 돌아가는 환경의 포트를 가져온다. ( 사용이 불가능할 때 기본은 3000번)
- server.use() : 미들웨어(=무거운 http를 들어주는 역할), 위의 코드에서는 미들웨어가 에러 핸들링 해준다.

```jsx
// VERB자리에 GET/POST, pathname은 도메인에 추가되는 문자열
// 콜백은 요청이 들어왔을 때 우리가 실행시킬 함수
server.VERB('route', callback);
```