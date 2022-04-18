package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

  @DisplayName("생성 시, 위치가 음수라면 예외를 던진다.")
  @Test
  void create() {
    assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void increment() {
    Position position = new Position(0).increment();
    assertThat(position).isEqualTo(new Position(1));
  }

  @Test
  void compareTo() {
    Position position = new Position(0);
    Position incrementedPosition = new Position(1);

    assertThat(position.compareTo(incrementedPosition)).isNegative();
    assertThat(incrementedPosition.compareTo(position)).isPositive();
  }
}
