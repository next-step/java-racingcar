# 문자열 사칙 연산 계산기 구현

### 기능 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현
- 문자열 계산기는 사칙연산의 계산 우선순위 아닌 입력 값에 따라 계산 순서가 결정
  <br>즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시
- 예를 들어 "2+3\*4/2"와 같은 문자열을 입력할 경우 2+3\*4/2 실행 결과인 10을 출력

### 구현 요구사항
- 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력

### 기능 분리
- 테스트할 수 있는 단위로 나누어 구현 목록을 만듬
    - 덧셈
    - 뺄셈
    - 곱셈
    - 나눗셈
    - 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    - 사칙 연산 기호가 아닌 경우 IllegalArgumentException throw
    - 사칙 연산을 모두 포함하는 기능 구현
- 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ")메소드 활용
- 반복적인 패턴을 찾아 반복문으로 구현

### JUnit, AssertJ 힌트

##### Exception 구현 힌트

- [AssertJ Exception Assertions 문서](https://www.baeldung.com/assertj-exception-assertion)

```java
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

assertThatExceptionOfType(IndexOutOfBoundsException.class)
  .isThrownBy(() -> {
      // ...
}).hasMessageMatching("Index: \\d+, Size: \\d+");
```

- 자주 발생하는 Exception 경우 Exception 별 메소드 제공
    - assertThatIllegalArgumentException()
    - assertThatIllegalStateException()
    - assertThatIOException()
    - assertThatNullPointException()

```java
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

assertThatIllegalArgumentException().isThrownBy(() -> {
    // ...
});
```

##### 테스트 데이터 전달

- [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

```java
@ParameterizedTest
@ValueSource(strings = {"", "  "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
```
