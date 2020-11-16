# 자동차 경주 게임 3
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 프로그래밍 요구사항 및 기타 요구사항
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
* 값을 입력 받는 API는 Scanner를 이용한다.
  ```editorconfig
  Scanner scanner = new Scanner(System.in);
  String value = scanner.nextLine();
  int number = scanner.nextInt();
  ```
* UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.
* else 예약어를 쓰지 않는다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * https://google.github.io/styleguide/javaguide.html
  * https://myeonguni.tistory.com/1596)
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* AngularJS Commit Message Conventions
  ```
  feat (feature)
  fix (bug fix)
  docs (documentation)
  style (formatting, missing semi colons, …)
  refactor
  test (when adding missing tests)
  chore (maintain)
  ```

## 구현할 기능 목록 step3
* 자동차 대수는 몇 대 인가요? 출력한다.
* 자동차 대수를 입력 받는다. - InputView
* 시도할 횟수는 몇 회 인가요? 출력한다. 
* 시도할 횟수를 입력 받는다. - InputView
* 자동차를 생성한다. - CAR
* 자동차 이동을 한다. (랜덤값 4이상이면 이동, 이하면 그대로)
* 실행 결과를 출력한다. - ResultView

----

# 자동차 경주게임 4
## 구현할 기능 목록 step4
* 경주할 자동차의 이름을 입력받는다. - InputView(이름은 최대 5자, 쉼표로 구분)
* 자동차를 이동한다. (자동차 이름 포함) 
* 자동차 경주 완료 후 우승자동차 이름 출력한다.

## 리뷰 반영 필요 목록 step4
* new Random().nextInt(10) 은 매번 method가 호출 될 때 마다 초기화 안되게 개선
* createRacingCars() 함수는 RacingGame의 역할로 개선
* ResultView만 담당하는 객체를 하나 생성 추가
* 움직임(RacingCarMoveBehavior)의 상태를 RacingCar가 가지고 있을 필요가 있을 까요??
생성 시점이 아닌 움직이는 시점에 전략이 반영되면 어떨까요??

## 힌트
* 자동차 이름을 쉼표(,)를 기준으로 분리하려면 String 클래스의 split(",") 메소드를 활용한다.
  `String[] names = inputName.split(",");`
 ----
 # 자동차 경주 5 Refactoring
 ## 요구사항
-[x] 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
-[x] MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, 
 domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.
-[ ] 테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.
  * RacingCar 클래스에 Random 값에 대해서 interface로 분리 및 test 작성
  * RacingCar내에 있는 원시타입에 대해서 클래스로 분리
  * 