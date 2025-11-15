package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.exception.RacingException;

class PositionTest {

  private Position position;

  @BeforeEach
  void init() {
    position = new Position();
  }

  @Test
  void checkPositionZero() {
    assertThat(position).isEqualTo(new Position(0));
  }

  @Test
  void increasePosition() {
    position.increase();
    assertThat(position).isEqualTo(new Position(1));
  }

  @Test
  void positionShouldThrowExceptionWhenMinus() {
    assertThatThrownBy(() -> new Position(-1))
        .isInstanceOf(RacingException.class)
        .hasMessageContaining("위치");
  }

  @Test
  void toStringFormat() {
    int POSITION = 3;
    for (int i = 0; i < POSITION; i++) {
      position.increase();
    }
    assertThat(position.toString()).isEqualTo("---");
  }
}