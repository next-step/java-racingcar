# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


# String 클래스에 대한 학습 테스트
### 요구사항 1
* "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
* "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

#### 힌트
* 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
* 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.

### 요구사항 2
* "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

### 요구사항 3
* "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
* String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
* JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
#### 힌트
* AssertJ Exception Assertions 문서 참고
<pre><code>import static org.assertj.core.api.Assertions.*;

assertThatThrownBy(() -> {
    // ...
}).isInstanceOf(IndexOutOfBoundsException.class)
  .hasMessageContaining("Index: 2, Size: 2");
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

assertThatExceptionOfType(IndexOutOfBoundsException.class)
  .isThrownBy(() -> {
      // ...
}).hasMessageMatching("Index: \\d+, Size: \\d+");</code></pre>

자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
* assertThatIllegalArgumentException()
* assertThatIllegalStateException()
* assertThatIOException()
* assertThatNullPointerException()

# Set Collection에 대한 학습 테스트
* 다음과 같은 Set 데이터가 주어졌을 때 요구사항을 만족해야 한다.
<pre><code>public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    // Test Case 구현
}</code></pre>
### 요구사항 1
* Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

### 요구사항 2
* Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
* 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
* JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
<pre><code>
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
</code></pre>
#### 힌트
* Guide to JUnit 5 Parameterized Tests
<pre><code>@ParameterizedTest
@ValueSource(strings = {"", "  "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}</code></pre>

### 요구사항 3
요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
#### 힌트
* Guide to JUnit 5 Parameterized Tests 문서에서 @CsvSource를 활용한다.
<pre><code>@ParameterizedTest
@CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
    String actualValue = input.toLowerCase();
    assertEquals(expected, actualValue);
}</code></pre>
* assertj 활용
    * Introduction to AssertJ 문서 참고해 assertj의 다양한 활용법 익힌다.
    
### Step1 리뷰 사항
* [x] [fix01][SetCollectionTest.java] hasSize를 활용할 수 있습니다


# 2단계 - 문자열 계산기
### 기능 요구사항
* 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
* 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
* 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
* 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
* 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 프로그래밍 요구사항
* 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
* 기능 분리 힌트
* 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
    * 덧셈
    * 뺄셈
    * 곱셈
    * 나눗셈
* 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
* 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
* 사칙 연산을 모두 포함하는 기능 구현
* 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
* 반복적인 패턴을 찾아 반복문으로 구현한다.

### Step2 리뷰 사항
* [x] [fix01][전체파일] if 다음에 공백, for 다음에 공백 컨벤션 준수하기 
* [x] [fix02][CalculationOperator.java] operation 이름을 의미있게 변경하기
* [x] [fix03][Calculator.java] validate 조건문 간소화 하기 
* [x] [fix04][Calculator.java] reduce를 활용하여 lamda식 변경해보기 
<pre><code>
private static int makeResult(List<Integer> numbers, List<CalculationOperator> operators) {
        int[] index = { 0 };
        int result = numbers.stream()
                            .reduce((preOperand, postOperand) -> {
                                 int sum = operators.get(index[0]).operation(preOperand, postOperand);
                                 index[0] += 1;
                                 return sum;
                            }).get();
        return result;
    }
</code></pre>

# 3단계 - 자동차 경주
### 기능 요구사항
* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 실행 결과
* 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
<pre><code>
자동차 대수는 몇 대 인가요?
3
시도할 회수는 몇 회 인가요?
5

실행 결과
-
-
-

--
-
--

---
--
---

----
---
----

----
----
-----
</code></pre>
### 힌트
* 값을 입력 받는 API는 Scanner를 이용한다.
<pre><code>
Scanner scanner = new Scanner(System.in);
String value = scanner.nextLine();
int number = scanner.nextInt();
</code></pre>
* 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.

### 프로그래밍 요구사항
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### Step3 리뷰사항 
* [x] [fix01][Entry.java] Domain과 View를 분리할 것
    * 만약 View의 변화로 인해 도메인 수정이 일어난다면 코드의 의존성을 넘어 아키텍처 강한 의존성이 생기게 됨
    * 비지니스 로직과 출력 로직을 도메인이 책임지고 있기 때문에 단일 책임의 원칙에도 위배
    * View 같은 세부 정보를 참조하여 복잡성을 더 추가한다면 복잡도가 더 증가하고 테스트 하기가 어려움
    * **그렇기에 출력에 관련된 로직은 출력 객체에게 위임 하는게 맞는 방법**
    * 하지만 출력 객체에게 로직을 위임하면 아키텍처 의존성 문제는 해결되지만 View가 도메인을 알게되는 문제점이 발생
    * 해당 경우는 여러 방법을 통해 데이터를 View에 전달할 수 있는 구조로 변경
        * 도메인을 그대로 노출하는 방법
        * DTO를 통해 필요한 데이터를 전달하는 방법
        * 읽기 전용 인터페이스를 만드는 방법

# 4단계 - 자동차 경주(우승자)
### 기능 요구사항
* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

### 실행 결과
* 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
* 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
<pre><code>
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

### 힌트
* 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
* indent가 2이상인 메소드의 경우 메소드를 분리하면 indent를 줄일 수 있다.
* else를 사용하지 않아 indent를 줄일 수 있다.
* 자동차 이름을 쉼표(,)를 기준으로 분리하려면 String 클래스의 split(",") 메소드를 활용한다.
<pre><code>String[] names = inputName.split(",");</code></pre>
* 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성한다.
* 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.

### 프로그래밍 요구사항
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
       
### Step4 리뷰 사항
* [ ] [fix01][RacingCar.java] 불변 객체로 만들어 보기
* [ ] [fix02][RacingCar.java] Object의 clone 보다 복사 객체를 이용하여 개선해보기 
    * clone을 지양하는 이유
        * Object의 clone 사용시 복제하려는 객체 내에 변경 가능한 인스턴스 객체 필드가 있을 경우 **얕은 복사**가 되며,
        * Object의 clone 메소드는 Checked Exception인 CloneNotSupportedException을 처리하도록 선언되어있지만 복사하다 예외가 발생하는 시점은 
        **런타임 시점**이기에 선언된 예외 타입의 예외 시점과 발생하는 예외 시점이 맞지 않는 보기 불편한(?) 문제
        * clone 메서드 **재 정의시 clone시 규약을 지키지 않으면 더욱 큰 문제**를 야기 할 수 있는 문제
* [ ] [fix03][SnapShotEntry.java] 최대 거리를 한번만 가져오도록 수정 
        