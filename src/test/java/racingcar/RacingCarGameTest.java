package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarGameTest {

  private RacingCarGame racingCarGame;

  @BeforeEach
  public void setUp() {
    racingCarGame = new RacingCarGame();
  }

  @Test
  public void throwIllegalArgumentExceptionTest() {
    MoveCondition testMoveCondition = new TestMoveCondition(true);
    assertThatThrownBy(() -> {
      racingCarGame.racing(0, testMoveCondition);
    }).isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> {
      racingCarGame.createCars(0);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("racing() 메서드 호출 시 자동차 객체 수만큼 리턴")
  public void racingCarGameTest() {
    MoveCondition testMoveCondition = new TestMoveCondition(true);
    RacingCarGame racingCarGame = new RacingCarGame();
    racingCarGame.createCars(3);
    assertThat(racingCarGame.racing(5, testMoveCondition).size()).isEqualTo(3);
  }

  @CsvSource(value = {"true, 1", "false, 0"})
  @ParameterizedTest(name = "isMovable()이 {0} 때 자동차 position: {1}")
  public void isMovableTest(boolean isMovable, int expectedPosition) {
    MoveCondition testMoveCondition = new TestMoveCondition(isMovable);
    racingCarGame.createCars(1);
    assertThat(racingCarGame.racing(1, testMoveCondition).get(0).getPosition()).isEqualTo(expectedPosition);
  }
}
