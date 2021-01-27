## Nginx.conf파일 간단 설명

# worker 프로세스를 실행할 사용자 설정
 - 이 사용자에 따라 권한이 달라질 수 있다.
 - user  nginx;
 
# 실행할 worker 프로세스 설정
 - 서버에 장착되어 있는 코어 수 만큼 할당하는 것이 보통, 더 높게도 설정 가능
 - worker_processes  1;

# 오류 로그를 남길 파일 경로 지정
error_log  /var/log/nginx/error.log warn;

# NGINX 마스터 프로세스 ID 를 저장할 파일 경로 지정
    - pid        /var/run/nginx.pid;


# 접속 처리에 관한 설정
events {
    # 워커 프로레스 한 개당 동시 접속 수 지정 (512 혹은 1024 를 기준으로 지정)
    worker_connections  1024;
}

# 웹, 프록시 관련 서버 설정
http {
    # mime.types 파일을 읽어들인다.
    include       /etc/nginx/mime.types;
    # MIME 타입 설정
    default_type  application/octet-stream;

    # 엑세스 로그 형식 지정
    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    # 엑세스 로그를 남길 파일 경로 지정
    access_log  /var/log/nginx/access.log  main;

    # sendfile api 를 사용할지 말지 결정
    sendfile        on;
    #tcp_nopush     on;

    # 접속시 커넥션을 몇 초동안 유지할지에 대한 설정
    keepalive_timeout  65;

    # (추가) nginx 버전을 숨길 수 있다. (보통 아래를 사용해서 숨기는게 일반적)
    server_tokens off

    #gzip  on;

    # /etc/nginx/conf.d 디렉토리 아래 있는 .conf 파일을 모두 읽어 들임
    include /etc/nginx/conf.d/*.conf;
}

------------------------
설정이 끝나고 아래의 명령어를 통해 nginx에 반영할 수 있다
$ service nginx reload;
