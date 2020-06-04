# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록 및 commit 로그 요구사항
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    * 참고문서: AngularJS Commit Message Conventions
<pre>
<code>
AngularJS Commit Message Conventions 중
commit message 종류를 다음과 같이 구분
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
end code block
</code>
</pre>
## 기능 요구사항
### 초간단 자동차 경주 게임을 구현한다.
* [ ] [feat#1] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* [ ] [feat#2] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* [ ] [feat#3] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
<pre><code>경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.</code></pre>

## 프로그래밍 요구사항
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    * 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 개선 요구사항
### step3 에서 나왔던 리뷰사항들
* [ ] [fix#01] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
* [ ] [fix#02] [RacingGame.java] 포지션 List를 저장하기 보다 Entry객체를 저장할 것
* [ ] [fix#03] [RacingGame.java] 포지션 List를 저장하기 보다 Entry객체를 저장할 것
* [ ] [fix#04] [RacingGameResultView.java] StringBuilder를 활용할 것
* [ ] [fix#05] [RacingEntryTest.java] 스트림을 사용할 땐 가독성을 위하여 기능단위로 줄바꿈 할 것
* [X] [fix#06] [RacingCar.java] ForwardingRule이라는 상태값이 반드시 필요하지 않으므로 move() 메소드를 실행 할때 Rule이 반영 될 수 있도록 변경할 것
* [ ] [fix#07] [RacingGameResultView.java] 출력하는 행위가 너무 복잡하므로 구조개선 할 
* [ ] [fix#08] [RacingGameResultView.java] 상수는 static final로 선언 할 것
* [ ] [fix#09] [RacingEntryTest.java] @ParameterizedTest를 활용할 것
* [ ] [fix#10] [RacingGameTest.java] assertAll을 사용할 것 (차이점도 알아 둘 것)
    * <pre><code>assertAll(
        () -> assertThat(result.size()).isEqualTo(carNumbers * raceTimes),
        () -> assertThat(result.stream()
                .filter(r -> r > 0)
                .count()).isEqualTo(carNumbers * raceTimes));</code></pre>

