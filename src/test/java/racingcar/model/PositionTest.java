package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  void create_fail() {
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
