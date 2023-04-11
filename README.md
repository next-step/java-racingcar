# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
---
# String 클래스에 대한 학습 테스트
### 요구사항 1
* "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
* "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
* 힌트
    * 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
    * 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.

### 요구사항 2
* "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

### 요구사항 3
* "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
* String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때
* 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
* JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

* 힌트
    * AssertJ Exception Assertions 문서 참고
    * import static org.assertj.core.api.Assertions.*;

~~~
assertThatThrownBy(() -> {
// ...
}).isInstanceOf(IndexOutOfBoundsException.class)
.hasMessageContaining("Index: 2, Size: 2");
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

assertThatExceptionOfType(IndexOutOfBoundsException.class)
.isThrownBy(() -> {
// ...
}).withMessageMatching("Index: \\d+, Size: \\d+");
~~~

* 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
    * assertThatIllegalArgumentException()
    * assertThatIllegalStateException()
    * assertThatIOException()
    * assertThatNullPointerException()

---
# Set Collection에 대한 학습 테스트
* 다음과 같은 Set 데이터가 주어졌을 때 요구사항을 만족해야 한다.
* public class SetTest {

~~~
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
}
~~~

### 요구사항 1
Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

### 요구사항 2
Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

~~~
@Test
void contains() {
assertThat(numbers.contains(1)).isTrue();
assertThat(numbers.contains(2)).isTrue();
assertThat(numbers.contains(3)).isTrue();
}
~~~

* 힌트
~~~
Guide to JUnit 5 Parameterized Tests
@ParameterizedTest
@ValueSource(strings = {"", "  "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
assertThat(Strings.isBlank(input)).isTrue();
}
~~~

### 요구사항 3
* 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다.
* 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
* 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
* 힌트
    * Guide to JUnit 5 Parameterized Tests 문서에서 @CsvSource를 활용한다.
~~~
@ParameterizedTest
@CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
String actual = input.toLowerCase();
assertThat(actual).isEqualTo(expected);
}
~~~
---
# assertj 활용
* Introduction to AssertJ 문서 참고해 assertj의 다양한 활용법 익힌다.

---
# 문자열 덧셈 계산기

### 기능 요구사항 
1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 
2. (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
3. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 
4. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
5. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
6. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 프로그래밍 요구사항
1. 메서드 분리

### 힌트
1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
~~~
   if (text == null) {}
   if (text.isEmpty()) {}
~~~
2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
~~~
   int number = Integer.parseInt(text);
~~~
3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
~~~
   String[] numbers = text.split(",");
   // 앞 단계의 구분자가 없는 경우도 split()을 활용해 구현할 수 있는지 검토해 본다.
 ~~~
4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
~~~
   String[] tokens= text.split(",|:");
~~~
5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
~~~
   // java.util.regex 패키지의 Matcher, Pattern import
   Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
   if (m.find()) {
   String customDelimiter = m.group(1);
   String[] tokens= m.group(2).split(customDelimiter);
   // 덧셈 구현
   }
~~~
6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
   구글에서 “junit4 expected exception”으로 검색해 해결책을 찾는다.

- TestCase 소스 코드
~~~
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
      int result = StringAddCalculator.splitAndSum(null);
      assertThat(result).isEqualTo(0);

      result = StringAddCalculator.splitAndSum("");
      assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
~~~
### AssertJ Exception Assertions 
- reference URL : https://www.baeldung.com/assertj-exception-assertion

---
# 자동차 경주
### 기능 요구사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 기능 요구사항 정리 List
- [ ] 이동 횟수 입력 기능
- [x] UI InputView 출력
- [ ] UI ResultView 출력
- [x] 랜덤 난수 생성 기능 : 0~9
- [x] 랜덤 난수 생성 결과 판단 기능
  - 0~3 : false 멈춤
  - 4~9 : ture 전진
- [ ] 자동차 이동 기능 : 랜덤 난수 생성 결과 true 리턴할 경우