# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## 기능 요구 사항
* step3
    * 초간단 자동차 경주 게임을 구현한다.
    * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
    * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
* step4
    * 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    * 자동차 이름은 쉼표(,)를 기준으로 구분한다.
    * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 리팩토링 요구사항
* step5
    핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
    MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.
    
## 실행 결과
* 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
```text
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

## 힌트 
* step3
    * 값을 입력 받는 API는 Scanner를 이용한다.
    ```java
    Scanner scanner = new Scanner(System.in);
    String value = scanner.nextLine();
    int number = scanner.nextInt();
    ```
    * 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.
    * 기본 뼈대 클래스는 다음 코드로부터 시작할 수 있다. 배열을 사용하는 것이 싫다면 ArrayList를 사용하는 것도 좋은 방법이다.
    ```java
    public class RacingGame {
        private int time;
        private int[] carPositions = {0, 0, 0};
        
        public int[] move() {
          // TODO 구현
        }
    }
    ```
* step4
    * 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
        * indent가 2이상인 메소드의 경우 메소드를 분리하면 indent를 줄일 수 있다.
        * else를 사용하지 않아 indent를 줄일 수 있다.
    * 자동차 이름을 쉼표(,)를 기준으로 분리하려면 String 클래스의 split(",") 메소드를 활용한다.
    ```java
    String[] names = inputName.split(",");
    ```
    * 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성한다.
    * 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.
  
  
## 프로그래밍 요구사항
* step3
    * 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
        * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
        * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
    * 자바 코드 컨벤션을 지키면서 프로그래밍한다.
        * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
    * else 예약어를 쓰지 않는다.
        * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
        * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
* step4
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

## 기능 목록 및 commit 로그 요구사항
* step3
    * 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
    * git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
        * 참고문서: AngularJS Commit Message Conventions
* step4
    * 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
    * git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### AngularJS Commit Message Conventions 중
* commit message 종류를 다음과 같이 구분
```text
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```
