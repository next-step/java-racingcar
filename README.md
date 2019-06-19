# 자동차 경주

## 기능 요구사항
- [ ] 초간단 자동차 경주 게임을 구현한다.
- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [ ] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [ ] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 실행 결과
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
- [ ] 값을 입력 받는 API는 Scanner를 이용한다.
- [ ] 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용다.
- [ ] 기본 뼈대 클래스는 다음 코드로부터 시작할 수 있다.
    ```java
    public class RacingGame {
        private int time;
        private int[] carPositions = {0, 0, 0};
        
        public int[] move() {
          // TODO 구현
        }
    }
    ```
- [ ] 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - [ ] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - [ ] UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다. 
    - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- [ ] else 예약어를 쓰지 않는다.
- [ ] 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- [ ] git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    - 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## 예외 처리
- [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw

## 프로그래밍 요구사항
- [x] 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

## 온라인 코드 리뷰 과정
- [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
