package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.property.CarRacingGameProperty;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    assertDoesNotThrow(CarName::new);
  }

  @DisplayName("생성자 테스트2")
  @Test
  void constructorTest2() {
    assertDoesNotThrow(() -> CarName.valueOf("test"));
  }

  @DisplayName("자동차 이름을 할당하지 않으면 default 값으로 생성한다.")
  @Test
  void constructor_givenNotCarName_assignDefaultCarName() {
    assertThat(new Car().getName()).isEqualTo(CarRacingGameProperty.CAR_DEFAULT_NAME);
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

  @DisplayName("자동차 이름이 null이면 RuntimeException을 던진다.")
  @Test
  void constructor_givenNull_throwsException() {
    assertThrows(RuntimeException.class, () -> CarName.valueOf(null));
  }
}
