## 기능 요구사항
- 각 자동차에 이름을 부여
- 자동차 이름은 최대 5자 -> 초과할 경우 에러 
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분한다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 객체
- 자동차 Car
    - 멤버    
        - 자동차 이름 public final String name 
        - 위치 정보 private int position 
        - 움직이는 방법 private MoveStrategy moveStrategy 
    - 생성자 
        - 멤버 변수 모두 초기화 
    - 메서드 
        - 전진 public void move 
        - 검사 private void validate
            - 자동차 이름 (비어있지 않나) throw error
        - 위치 리턴 public int getPosition
- 자동차들 Cars
    - 멤버     
        - 자동차들 list public final List<Car>
    - 생성자
        - 자동차 이름의 배열 private final String[] carNames
        - 자동차들에게 일괄적으로 적용할 private final int position 
        - 자동차들에게 일괄적으로 적용할 private final MoveStrategy moveStrategy
    - 메서드
        - 자동차를 한회차 이동시킴 public void move
        - 자동차 배열이 유효한지 검사 private void validate -> 무엇이 유효한지 검사하는 기준을 안적어서 까먹음
- 입력기
    - 쉼표로 구분한 자동차들이름 static public String readString 
    - 시도 횟수 static public readInteger int 
- 출력기
    - 멤버
        - 자동차 종류 private final String carKind;
    - 실행 결과 public void printRace
    - 우승 자동차 이름들 public void printWinner
- 경주
    - 멤버
        - 경주 횟수 private final int numberOfMoves
        - 경주에 참여시킬 자동차들 private final Cars cars;
    - 생성자
        - 경주 횟수를 검증하고 검증횟수, 경주에 참여시킬 자동차들을 초기화
    - 메서드
        - 경주 횟수 검증 (양수인지) private static void validateNumberOfMoves
        - 경주 운행 public void operate(Result view) 
        
## 실행결과
```shell script
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
- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
    - indent 가 2이상인 메소드의 경우 **메소드를 분리**하면 indent를 줄일 수 있다.
    - **else를 사용하지 않아** indent를 줄일 수 있다.

## 프로그래밍 요구사항
- indent(인덴트, **들여쓰기) depth를 2**를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 **15라인**을 넘어가지 않도록 구현한다.
    - **함수(또는 메소드)가 한 가지 일**만 잘 하도록 구현한다.
- **모든 로직에 단위 테스트**를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    
## 피드백
### 준일님
* collectingAndThen
```java
private static List<Car> createCars(String[] names, int position, MoveStrategy moveStrategy) {
    return Arrays.stream(names)
            .map(name -> Car.of(name, position, moveStrategy))
            .collect(Collectors.toList());
```
```java
private static List<Car> createCars(String[] names, int position, MoveStrategy moveStrategy) {
    return Arrays.stream(processNames(carNames))
          .map(name -> Car.of(name, position, moveStrategy))
        .collect(collectingAndThen(toList(), Cars::new));
}
```

### gmlwjd9405
```java
@DisplayName("Cars 생성: Car 의 이름 배열을 생성자의 인자로 받아 생성")
@Test
void create() {
    assertThatCode(() -> Cars.of(carNames.get(CASE.THREE_VALUES)))
            .doesNotThrowAnyException();
}
```