# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---
# STEP3. 자동차 경주
## 기능 요구사항
> - 초간단 자동차 경주 게임을 구현한다. 
> - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
> - 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
> - 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
> - 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- [x] 0에서 9 사이 random 값을 생성한다.
- [x] random 값이 4이상일 경우에 전진하고, 그렇지 않으면 정지한다.
- [x] 자동차 대수와 시도할 회수를 순서대로 입력받는 안내문구를 출력하고 입력받는다.
    ```
    자동차 대수는 몇 대 인가요?
    3
    시도할 회수는 몇 회 인가요?
    5
    ```
- [x] 주어진 횟수 동안 n대의 자동차는 전진하거나 멈출 수 있으며, 횟수마다 실행 결과를 출력한다.
    ```
   실행 결과
    -
    -
    -
  
    --
    -
    --
    ```
## 프로그래밍 요구사항
- [x] 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 race.view.InputView, ResultView와 같은 클래스를 추가해 분리한다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 이 과정의 Code Style은 [intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html)을 따른다.
  - intellij idea Code Style. Java을 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (Command) + L.)를 사용한다.
- [x] else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 기능 목록 및 commit 로그 요구사항
- [x] 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- [x] git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    - 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## 코멘트
- [x] View가 상태를 가지고 있는게 맞을까요?
- [x] 객체지향 설계: Car라는 도메인이 있고 그 Car가 Position을 가지고 있고, move하는 행위도 스스로 하는거 아닐까요?
- [x] 상수를 통해 해당 코드의 의미를 나타내보시면 어떨까요?
- [x] String.repeat() 사용
- [x] [일급컬렉션 적용](https://jojoldu.tistory.com/412) `private final List<race.domain.Car> cars = new ArrayList<>();`
- [x] [테스트 하기 좋은 코드로 인터페이스를 통해 전략패턴](https://tecoble.techcourse.co.kr/post/2020-05-17-appropriate_method_for_test_by_interface/)
  - canMove에서 랜덤값을 처리하기 떄문에 실제 테스트를 하기가 어려운 문제가 있습니다. 이유는 position이 1이 될지, 0이 될지 알수가 없기 떄문이죠.
- [x] position을 생성할때 0이 아닌 다른 값을 넣어 생성시 문제가 생길수도 있다!
- [x] move를 할때마다 RandomNumberGenerator를 만들 이유가 있을까요? 아래의 함수와 차이가 무엇인가요?
- [x] 10이라는 값을 상수를 통해 의미 전달을 해볼까요?
- [x] 현재는 어떻게 보면 통합테스트만 존재한다고 볼수 있습니다. Car나 CarGroup과 같은 메서드들의 단위 테스트를 추가해보시면 어떠실까요?
- [x] 대부분 collection은 Cars라는 복수를 사용하고 있습니다.
- [x] 폴더 구조도 아키텍쳐를 이해하는데에 있어 가장 좋은 방안입니다. 지금은 하나의 폴더에 모든 파일들이 있는데 아키텍쳐에 맞게 폴더(패키지)구조를 짜보시면 어떨까요?

---
# STEP4. 자동차 경주(우승자)
## 기능 요구사항
> - 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
> - 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
> - 자동차 이름은 쉼표(,)를 기준으로 구분한다.
> - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
- [ ] 사용자는 자동차의 이름을 쉼표로 구분하여 입력한다.
- [ ] 각 자동차에 이름을 부여할 수 있다.
- [ ] 자동차의 이름이 null 이거나 빈 값이면, 에러가 발생한다.
- [ ] 자동차의 이름이 5자를 초과하면, 에러가 발생한다.
- [ ] 자동차 경주 게임을 완료하면 우승자가 반환된다.
- [ ] 자동차 경주 게임을 한번 실행했을 때, 위치를 반환한다.
- [ ] 자동차 경주 게임을 실행할 때마다 위치를 출력한다.
- [ ] 자동차 경주 우승자의 우치를 출력한다.

### 실행 결과
3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
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

pobi, honux가 최종 우승했습니다.
```

## 프로그래밍 요구사항
- [ ] indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- [ ] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- [ ] 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- [ ] else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 기능 목록 및 commit 로그 요구사항
- [x] 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- [x] git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.