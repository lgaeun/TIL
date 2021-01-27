### mac용 패키지 관리자

- brew 명령어를 통해 설치한 패키지 저장 위치: /usr/local/Cellar

```bash
brew install $(package)
brew uninstall $(package)
brew upgrdae $(package)
brew search $(package) // brew로 설치한 패키지 찾아보기
brew list // 설치한 패키지들 보기
brew remove --force --ignore-dependencies $(brew list) //Homebrew로 설치한 모든 package 일괄 삭제 방법
```

- Homebrew cask
    - GUI기반 어플리케이션(크롬, sublime 등) 설치를 위해 미리 설치해야 하는 패키지

    ```bash
    brew cask install Brackets    //bracket설치
    ```