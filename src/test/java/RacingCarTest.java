import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

  @Test
  @DisplayName("move 전략 리턴값이 true일 때 RacingCar의 progress값에 1이 더해지는지 검증하기 위한 테스트")
  void move() {
    // given
    RacingCar racingCar = new RacingCar();
    int expectedProgress = 1;

    // when
    racingCar.move(() -> true);

    // then
    assertThat(racingCar.getProgress()).isEqualTo(expectedProgress);
  }

  @Test
  @DisplayName("move 전략 리턴값이 false일 때 RacingCar의 progress값에 1이 더해지는지 검증하기 위한 테스트")
  void dontMove() {
    // given
    RacingCar racingCar = new RacingCar();
    int expectedProgress = 0;

    // when
    racingCar.move(() -> false);

    // then
    assertThat(racingCar.getProgress()).isEqualTo(expectedProgress);
  }

}
