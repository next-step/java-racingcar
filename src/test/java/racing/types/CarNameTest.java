package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    assertDoesNotThrow(CarName::new);

    CarName carName = new CarName();
    assertThat(carName).isEqualTo(carName);
  }

  @DisplayName("생성자 테스트2")
  @Test
  void constructorTest2() {
    assertDoesNotThrow(() -> CarName.valueOf("test"));
  }

  @DisplayName("생성자 테스트3")
  @Test
  void constructorTest3() {
    assertDoesNotThrow(() -> CarName.valueOf(new CarName()));
  }

  @DisplayName("자동차 이름의 길이는 5 이하이다.")
  @ParameterizedTest
  @ValueSource(strings = {"a", "aa", "aaa", "aaaa", "aaaaa"})
  void constructor_givenCarNameLengthIsFiveOrLess_doesNotThrowException(String carName) {
    assertDoesNotThrow(() -> CarName.valueOf(carName));
  }

  @DisplayName("자동차 이름의 길이가 6 이상이면 RuntimeException을 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"abcdef", "longname", "123456", "longerName"})
  void constructor_givenCarNameLengthIsSixOrMore_throwsException(String carName) {
    assertThrows(RuntimeException.class, () -> CarName.valueOf(carName));
  }

  @DisplayName("자동차 이름이 빈 문자열이면 RuntimeException을 던진다.")
  @Test
  void constructor_givenEmptyStringName_throwsException() {
    assertThrows(RuntimeException.class, () -> CarName.valueOf(""));
  }
}
