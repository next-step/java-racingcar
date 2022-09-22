# 자동차 경주 게임

## 초간단 자동차 경주 게임 구현

### 기능 요구사항
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지 입력할 수 있어야 한다.
    - 자동자 수와 이동 수 입력시 숫자를 제외한 문자가 입력되면 다시 입력하도록 유도한다.
    - 0 이하의 수가 입력되면 사시 입력하도록 유도한다.
- 사용자가 입력한 n대의 자동차는 사용자가 입력한 횟수만큼 이동하거나 이동하지 않을 수 있다.
    - 0 ~ 9 사이의 random 값을 구한다.
    - random 값이 4 이상인 경우 전진힌다.
- 자동차의 상태를 화면에 출력한다.
    - 한번 이동 마다 출력.

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