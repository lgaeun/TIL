## MiddleWare란?
- 요청에 대한 응답 과정 중간에 껴서 어떤 동작을 해주는 프로그램
- 예) 익스프레스: 어떤 요청 들어옴 -> 미들웨어에서 지정한 동작을 수행 -> 응답

### Express의 미들웨어들의 역할
1. Morgan: 익스프레스 프레임워크가 동작하면서 나오는 메세지들을 콘솔에 표시
2. Compression: 페이지를 압축해 전송
3. Session: 세션 사용할 수 있게 해 줌
4. Body-parser: 폼에서 전송되는 POST값을 사용할 수 있게 해 줌
5. Cookie-parse: 쿠키 사용 가능하게 해 줌
6. Cors: 크로스오리진(다른 도메인 간의 AJAX 요청)가능하게 해 줌
7. Method-override: REST API에서 PUT, DELETE 메소드 사용하고 싶을 때
8. Static: 

- 아래 형식으로 사용할 미들웨어를 응답 보내기전에 넣어주면 된다.
```
const express = require('express');
const app = express();

// app.use(미들웨어)
app.use(compression());
app.use(cors());
```
