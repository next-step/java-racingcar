package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static racingcar.Car.EMPTY_STRING_ERROR_MESSAGE;
import static racingcar.Car.MAX_LENGTH_ERROR_MESSAGE;
import static racingcar.Car.UNIT;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  public static final String EMPTY_STRING = "";

  Car car;

  static Stream<Arguments> distances() {
    return Stream.of(
        arguments(0, EMPTY_STRING),
        arguments(1, UNIT),
        arguments(2, UNIT + UNIT),
        arguments(3, UNIT + UNIT + UNIT)
    );
  }

  static Stream<Arguments> movements() {
    return Stream.of(
        arguments(0, EMPTY_STRING),
        arguments(3, EMPTY_STRING),
        arguments(4, UNIT),
        arguments(9, UNIT)
    );
  }

  static Stream<Arguments> nameAndErrorMessage() {
    String wrongName = "abcdef";
    return Stream.of(
        arguments(null, EMPTY_STRING_ERROR_MESSAGE),
        arguments("", EMPTY_STRING_ERROR_MESSAGE),
        arguments(wrongName, MAX_LENGTH_ERROR_MESSAGE + wrongName)
    );
  }

  @BeforeEach
  void setUp() {
    car = new Car("a");
  }

  @ParameterizedTest
  @DisplayName("자동차는 4이상이면 전진하고, 미만이면 정지한다.")
  @MethodSource("movements")
  void move(int randomNumber, String expected) {
    // given
    // when
    car.move(randomNumber);

    assertThat(car.showStatus()).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("해당 횟수만큼 전진한 자동차의 상태를 확인한다. 이동 거리는 '-'로 표시한다.")
  @MethodSource("distances")
  void status(int distance, String expected) {
    for (int i = 0; i < distance; i++) {
      car.move(4);
    }

    assertThat(car.showStatus()).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("자동차는 이름을 가지고 생성할 수 있다.")
  @ValueSource(strings = {"pobi", "crong", "honux", "jk", "dion"})
  void createWithName(String name) {
    car = new Car(name);

    assertThat(car.getName()).isEqualTo(name);
  }

  @ParameterizedTest
  @DisplayName("자동차 이름은 1~5자여야 한다. 그 외의 경우 예외를 리턴한다.")
  @MethodSource("nameAndErrorMessage")
  void createWithInvalidName(String name, String errorMessage) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new Car(name))
        .withMessage(errorMessage);
  }
}
