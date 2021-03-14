package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Position;

public class PositionTest {

  private Position position;

  @BeforeEach
  void setUp() {
    position = new Position(3);
  }

  @Test
  @DisplayName("[Position] Position 생성 테스트")
  void createPosition() {
    assertThat(position).isEqualTo(new Position(3));
  }

  @Test
  @DisplayName("[Position] 자동차 이동 테스트")
  void moveTest() {
    position.move();
    assertThat(position).isEqualTo(new Position(4));
  }
}
