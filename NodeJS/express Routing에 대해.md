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
  
  참고: https://www.zerocho.com/category/NodeJS/post/578b5a36d8316615006bee0f
