# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항

### 기능 요구사항

- [x] 초간단 자동차 경주 게임을 구현한다.
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [x] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 프로그래밍 요구사항

- [x] 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 이 과정의 Code Style은 [intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html)을 따른다.
    - intellij idea Code Style. Java을 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (
      Command) + L.)를 사용한다.
- [x] else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 기능 목록 및 commit 로그 요구사항

- [x] 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- [x] git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    - 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## 설계

### 기능 목록

- UI 로직
    - 인풋 받기 (InputView)
        - 자동차 대수 입력받기
            - 자동차는 10개 이하로 생성하도록 제한
        - 시도할 횟수 입력받기
            - 시도할 횟수는 20회 이하로 제한
    - 결과 출력하기 (ResultView)
        - 경기 클래스를 받을 수 있도록
- 핵심 로직
    - 자동차 (RacingCar)
        - 자동차 생성하기
        - 자동차 전진하기
            - 0~9 랜덤값 생성하기
            - 값이 4 이상이면 true 반환
    - 경기 (RacingGame)
        - 경기 정보 받기 (InputView)
        - 자동차 생성하기 (RacingCar)
        - 경기 시작하기
            - 한 사이클 진행 (자동차 갯수만큼 전진시키기)
            - 결과 출력하기 (ResultView)

### 테스트 케이스

- [x] 자동차 생성
- [x] 자동차 전진하기
- [x] 경기 정보가 정상적으로 받아지는지 확인하기
- [x] 자동차 입력을 1~10으로 입력한 경우 (정상)
- [x] 자동차 입력을 1~10이 아닌 정수를 입력한 경우 (예외)
- [x] 자동차 입력을 실수, 문자열 등의 정수가 아닌 값을 입력한 경우 (예외)
- [x] 시도 횟수 입력을 1~20으로 입력한 경우 (정상)
- [x] 시도 횟수 입력을 1~10이 아닌 정수를 입력한 경우 (예외)
- [x] 시도 횟수 입력을 실수, 문자열 등의 정수가 아닌 값을 입력한 경우 (예외)
- [x] 경기에서 자동차 수, 시도 횟수 입력받기
- [x] 경기 시작하기
