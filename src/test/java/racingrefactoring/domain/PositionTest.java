package racingrefactoring.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  void move() {
    Position position = new Position();
    position.move();

    assertThat(position.getPosition()).isEqualTo(1);
  }

  @Test
  void isSame() {
    Position position = new Position();
    position.move();
    position.move();
    position.move();

    assertThat(position.isMax(new Position(3))).isTrue();
  }
}