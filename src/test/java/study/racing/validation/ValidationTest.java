package study.racing.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {

  @DisplayName("Integer 값을 입력시 null validation 테스트")
  @ParameterizedTest
  @NullSource
  void checkValue(Integer input) {
    assertThrows(IllegalArgumentException.class,
        ()->{
          Validation.checkValue(input);
        });
  }

  @DisplayName("String 값을 입력시 Null or Blank validation 테스트")
  @ParameterizedTest
  @NullSource
  @EmptySource
  void checkNullValue(String input) {
    assertThrows(IllegalArgumentException.class,
        ()->{
          Validation.checkNullValue(input);
        });
  }

  @DisplayName("입력값 글자길이 5초과 제한 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"가나다라마바","하나둘셋넷다섯"})
  void checkValueLimitLength(String input) {
    assertThrows(IllegalArgumentException.class,
        ()->{
          Validation.checkValueLimitLength(input,5);
        });
  }

  @DisplayName("String 입력값 Null/Blank & 글자길이 5초과 테스트")
  @ParameterizedTest
  @NullSource
  @EmptySource
  @ValueSource(strings= {"가나다라마바","하나둘셋넷다섯"})
  void checkName(String input) {
    assertThrows(IllegalArgumentException.class,
        ()->{
          Validation.checkName(input,5);
        });
  }

  @DisplayName("거리입력시 0이상만 가능한지 테스트")
  @ParameterizedTest
  @ValueSource(ints = {-1,-2})
  void checkWholeNumber(int input) {
    assertThrows(IllegalArgumentException.class,
        ()->{
          Validation.checkMinimumNumber(input);
        });
  }
}