# 자동차 경주 게임

## 초간단 자동차 경주 게임 구현

### 기능 요구사항
- 자동자
  - 움직일 수 있다.
  - 움직이지 않을 수 있다.
- 조건
  - 0 ~ 9 의 랜덤 값이 4 이상인 경우와 아닌 경우를 알려줄 수 있다.
- 입력
  - 자동차 수를 입력 받는다.
  - 움직임 수를 입력 받는다.
- 출력
  - 자동차의 위치를 출력할 수 있다.
- 레이싱 게임
  - 자동차들을 움직인다.
- 게임 컨트롤러
  - 입력을 받고 게임을 진행한뒤 결과를 출력한다.

### 프로그래밍 요구사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해본다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - Code Style은 intellij idea Code Style. Java을 따른다.
- else 예약어를 쓰지 않는다.
    - switch/case도 사용하지 않는다.

### 기능 목록 및 commit 로그 요구사항
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    - 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)