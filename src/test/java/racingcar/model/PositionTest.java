package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

  @Test
  @DisplayName("자동차 출발 위치 초기값 셋팅 확인")
  void checkPositionInitialValue() {
    Position position = new Position();
    assertThat(position.getValue()).isEqualTo(0);
  }

  @ParameterizedTest
  @DisplayName("자동차 위치 이동후 결과 확인")
  @CsvSource({"0,1", "2,3", "5,6", "10,11"})
  void checkResultMovedCarLocation(int input, int expected) {
    Position position = new Position(input);

    position.increaseValue();

    assertThat(position.getValue()).isEqualTo(expected);
  }
}