### web api 디자인 가이드
  - URI는 정보의 자원을 표현해야 함
  - 자원에 대한 행위는 http method(get, post, put, delete)로 표현
  - post: url를 요청하면 리소스를 생성
  - get : 해당 리소스 조회, 해당 도큐먼트에 대한 정보 가져오기
  - put: 해당 리소스 수정
  - delete: 리소스 삭제
  
### Ajax
- 브라우저가 새로고침 없이 필요한 부분의 데이터를 얻어오는 방법, 즉 비동기식으로 서버로부터 데이터를 가져오는 방법
- ajax 통신으로 xml, plain text, json등 다양한 포맷이 있지만 대표적으로 json 사용
- Ajax 코드 예시
  ```
  function ajax(data){
    var oReq = new XMLHttpRequest();  //(1)XMLHttpRequest 객체 생성
    oReq.addEventListener("load", function() {  //(4) 서버에서 응답이 오면(요청처리가 완료) load이벤트 발생, 콜백함수 실행됌(이때는 이미 ajax함수는 반환되고 콜스택에서 사라진 상태)
      console.log(this.responseText);
    });
    oReq.open("GET", {url}); //(2)open methodfh 요청 준비
    oReq.send();  //(3) 서버로 전송
  }
  ```
  - Cors (Cross Origin Resource Sharing)
    - 브라우저가 cross origin 요청에 대한 응답 액세스에서 FE javascript 코드 차단 여부를 결정할 수 있음
    - 원래 보안 상의 이유로 브라우저는  cross origin http 요청을 제한. BUT, CORS는 브라우저가 리소스로드를 허용해야하는 origin이외에 다른 origin(domain, port 등)을 서버가 나타낼 수 있도록 하는 http 헤더 기반 메커니즘
    - 즉, same-origin 요청은 항상 허용, cross-origin 요청은 CORS에 의해 control
    - origin: 프로토콜, 주소, 포트번호의 쌍 (Origin = [프로토콜]://[Host의 IP 주소 또는 URL]:[포트번호])
    - cross origin: 프로토콜(http,https)이 다르거나, 주소(a.com, b.com, ...)이 다르거나, 포트번호(80, 443 etc)가 다른 것
    - 해결방법: 
      - 허용할 Origin을 Access-Control-Allow-Origin 응답 헤더에 넣어주면 된다
      - 즉 cross origin 요청을 보낼 때 미리 내 요청을 받을 수 있는지 확인하기 위해 사전요청(Preflight Request) 보내기.
      - 예시
      ```
      # Flask 서버
      import flask
      app = flask.Flask(__name__)
 
      @app.route("/", methods=["GET", "DELETE", "OPTIONS"])
      def index():
          my_res = flask.Response()
 
          http_method = flask.request.method
 
          if http_method == "OPTIONS": # 사전요청
             print("--사전 요청(Preflight Request)--")
              my_res.headers.add("Access-Control-Allow-Origin", "*")
              my_res.headers.add('Access-Control-Allow-Headers', "*")
              my_res.headers.add('Access-Control-Allow-Methods', "GET,DELETE")
          elif http_method == "GET": # 실제요청
              print("--실제 요청--")
              my_res.headers.add("Access-Control-Allow-Origin", "*")
              my_res.set_data("가져왔지롱")
          elif http_method == "DELETE": # 실제요청
              print("--실제 요청--")
              my_res.headers.add("Access-Control-Allow-Origin", "*")
              my_res.set_data("삭제했지롱")
          else: 
              print("요구하지 않은 HTTP METHOD(" + http_method + ")입니다.")       
    
          return my_res
 
      app.run(host='127.0.0.1', port=8888)
      
      ```
      - 두번의 요청
        1. 사전요청: Http-options method로 보내기. 이 요청의 응답으로는 쓰이게 될 환경에 대한 내용.(어떤 종류의 http 메소드 허용할건지, 어떤 헤더의 요청을 허용할건지 or else default: get,post)
        2. 실제요청: 이 요청에 대한 응답은 실제 메세지 내용
