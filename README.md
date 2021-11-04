# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능 요구사항

* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 실행 결과

* 위 요구사항에 따라 3대의 자동차가 3번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

```
자동차 대수는 몇 대 인가요?
3
시도할 회수는 몇 회 인가요?
5

실행결과
ㅡ
ㅡ
ㅡ

ㅡㅡ
ㅡ
ㅡㅡ

ㅡㅡㅡ
ㅡㅡ
ㅡㅡㅡ

ㅡㅡㅡㅡ
ㅡㅡㅡ
ㅡㅡㅡㅡ

ㅡㅡㅡㅡ
ㅡㅡㅡㅡ
ㅡㅡㅡㅡㅡ
```

## 힌트

* 값을 입력받는 API는 Scanner를 이용한다.

```
Scanner scanner = new Scanner(System.in);
String value = scanner.nextLine();
int number = scanner.nextInt();
```

## 프로그래밍 요구사항

* 모든 로직에 단위 테스트를 구현한다. 단,UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
    * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 기능 분리 힌트

* 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
    * 덧셈
    * 뺄셈
    * 곱셈
    * 나눗셈
    * 입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    * 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
    * 사칙 연산을 모두 포함하는 기능 구현
* 공백 문자열을 빈 공백 문자로 분리 하려면 String 클래스의 split(" ") 메소드를 활용한다.
* 반복적인 패턴을 찾아 반복문으로 구현한다.

## 기능 목록 및 commit 로그 요구사항

* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    * 참고문서: AngularJS Commit Message Conventions

## AngularJS Commit Message Conventions 중

* commit message 종류를 다음과 같이 구분
```
[Feat] 새로운 기능을 추가할 경우
[Ftx] 버그를 고친 경우
[Docs] 문서를 수정한 경우
[Style] 코드 코맷변경, 세미콜론 누락, 코드 수정이 없는경우
[Refactor] 프로덕션 코드 리팩토링
[Test] 테스트 추가, 테스트 리팩토링(트로덕션 코드 변경 X)
[chore]빌드 테스트 업데이트, 패키지 매니저를 설정하는 경우(프로덕션 코드 변경 X)
```

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)