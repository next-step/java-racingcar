package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {

  RacingCarGame racingCarGame;

  @BeforeEach
  public void setUp() {
    racingCarGame = new RacingCarGame();
  }

  @Test
  public void throwIllegalArgumentExceptionTest() {
    assertThatThrownBy(() -> {
      racingCarGame.racing(0);
    }).isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> {
      racingCarGame.createCars(0);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("racing() 메서드 호출 시 자동차 객체 수만큼 리턴")
  public void racingCarGameTest() {
    RacingCarGame racingCarGame = new RacingCarGame();
    racingCarGame.createCars(3);
    assertThat(racingCarGame.racing(5).size()).isEqualTo(3);
  }
}
