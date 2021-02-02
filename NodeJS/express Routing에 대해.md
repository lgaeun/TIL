###라우팅
- 익스프레스의 장점 중 하나로, 클라이언트에서 보내는 주소에 따라 다른 처리를 하는 것
- REST API에 따라 처리한다
- REST 메소드: ```app.get```, ```app.post```, (+ ```app.put```, ```app.delete``` : method-override 패키지 설치 후 사용가능)
  - ```
    //app[REST메소드]('주소', 콜백함수)형식
    ```
  - 와일드카드를 사용할 땐 순서가 중요하다. post/a에 요청이 왔을 때 post/:id에 걸린다. 그래서 항상 와일드 카드는 다른 라우터들보다 뒤에 적을 것!
  ```
  app.get('/post/:id', () => {});
  app.get('/post/a', () => {});

  ```
  - 라우터 서버와 분리하기. 모듈로 만들어 server.js에서 불러오기 => 유지보수 쉬움
  ```
  const express = require('express');
  const path = require('path');
  const router = express.Router(); // 라우터 분리
  router.get('/', (req, res) => { // app 대신 router에 연결
    res.sendFile(path.join(__dirname, 'html', 'main.html'));
  });
  router.get('/about', (req, res) => {
   res.sendFile(path.join(__dirname, 'html', 'about.html'));
  });
  module.exports = router; // 모듈로 만드는 부분
  ```
  
  참고: https://www.zerocho.com/category/NodeJS/post/578b5a36d8316615006bee0f
