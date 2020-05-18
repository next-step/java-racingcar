package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

  @DisplayName("단일 전진 테스트 : 자동차가 정상적으로 전진 되었는지 확인")
  @Test
  void 단일_전진_테스트 () {
    assertThat(Car.of().move().move().getPositionString()).isEqualTo("--");
  }

  @DisplayName("전진 테스트 : 자동차가 주어진 값 만큼 정상적으로 전진 되었는지 확인")
  @ParameterizedTest
  @MethodSource("provideCarAndTargetPosition")
  void 전진_테스트 (Car car, int going, String expected) {
    assertThat(car.move(going).getPositionString()).isEqualTo(expected);
  }

  private static Stream<Arguments> provideCarAndTargetPosition () {
    return Stream.of(
      Arguments.of(Car.of(), 3, "---"),
      Arguments.of(Car.of(), 5, "-----"),
      Arguments.of(Car.of(), 7, "-------"),
      Arguments.of(Car.of(), 9, "---------")
    );
  }
}
