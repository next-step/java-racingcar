# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


___

# 요구사항 분석
## step1 - 문자열 계산기
### 기능 요구사항
* 덧셈
* 뺄셈
* 곱셈
* 나눗셈
* 주어진 문자열을 연산하기 위한 형태로 파싱
* 주어진 문자열을 연산

### 프로그래밍 요구사항
* 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력 해 본다.

## step2 - 자동차 경주
### 기능 요구사항
* 자동차가 전진한다.
* 0~9 사이의 random값 중 4 이상일 경우 전진한다.
* 자동차가 멈춘다.
* 사용자가 횟수를 입력할 수 있다.
* 주어진 횟수 동안 자동차가 전진/멈춘다.
* 사용자가 자동차 대수를 입력할 수 있다.
* 주어진 횟수 동안 n대의 자동차가 전진/멈춘다.
* 자동차의 상태를 화면에 출력한다.

### 프로그래밍 요구사항
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    
### 기능 목록 및 commit 로그 요구사항
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    * 참고문서: AngularJS Commit Message Conventions [https://gist.github.com/stephenparish/9941e89d80e2bc58a153]