package racingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.Position;

public class PositionTest {

  @DisplayName("이동 테스트")
  @Test
  void move() {
    Position position = new Position(5);
    assertThat(position.move()).isEqualTo(new Position(6));
  }

  @DisplayName("음수 입력하면 예외 발생")
  @Test
  void less_zero_then_throw_Exception() {
    assertThatThrownBy(() ->new Position(-1)).isInstanceOf(IllegalArgumentException.class);
  }

}
