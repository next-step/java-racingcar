package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.Movement;
import racingcar.domain.Position;


public class MovementTest {

  private Position position;
  private Movement movement;

  @BeforeEach
  void setUp() {
    position = new Position(0);
    movement = new Movement();
  }

  @Test
  @DisplayName("[Movement] 자동차를 움직이지 않았을 때의 트랙 테스트")
  void trackingMovementTest() {
    assertEquals("", Movement.trackingMovement(position, "-"));
  }

  @Test
  @DisplayName("[Movement] 자동차를 움직이고 난 후의 트랙 테스트")
  void trackingAfterMovementTest() {
    position.move();
    assertEquals("-", Movement.trackingMovement(position, "-"));
  }

  @ParameterizedTest(name = "[Movement] 자동차 전진 기준 테스트-{index}")
  @CsvSource(value = {"4:true", "1:false", "9:true", "7:true", "2:false"}, delimiter = ':')
  void isMoveableTest(int number, boolean expected) {
    assertThat(movement.isMoveable(number)).isEqualTo(expected);
  }
}
