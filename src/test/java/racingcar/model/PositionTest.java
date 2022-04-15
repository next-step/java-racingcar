package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  void increment() {
    Position position = new Position(0).increment();
    assertThat(position).isEqualTo(new Position(1));
  }
}
