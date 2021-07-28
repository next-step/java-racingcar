package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberMovableConditionTest {

  public static final int BOUNDARY_NUMBER = 4;
  public static final int NOT_SATISFY_NUMBER = 3;

  @ParameterizedTest(name = "주어진 숫자가 {0} 일 때 움직일 수 있는 조건을 {1} 을 반환한다")
  @MethodSource("provider")
  void satisfy(int number, boolean expected) {
    final MovableCondition movableCondition = new NumberMovableCondition(number);

    assertThat(movableCondition.satisfy()).isEqualTo(expected);
  }

  static Stream<Arguments> provider() {
    return Stream.of(
        Arguments.of(BOUNDARY_NUMBER, true),
        Arguments.of(NOT_SATISFY_NUMBER, false)
    );
  }

  @ParameterizedTest(name = "주어진 숫자가 {0} 일 때 예외가 발생한다")
  @ValueSource(ints = {-1, 10})
  void validate(int number) {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new NumberMovableCondition(number));
  }


}