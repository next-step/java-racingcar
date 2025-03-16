package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

  @Test
  @DisplayName("입력한 자동차 수만큼 자동차가 초기화 된다.")
  void createCars() {
    int carCount = 5;
    int dummyNumber = 1;
    Racing racing = new Racing(carCount, dummyNumber, new FixedNumberGenerator(dummyNumber));
    assertThat(racing.getCars()).hasSize(carCount);
  }

  @Test
  @DisplayName("레이싱이 진행되면 입력한 라운드만큼 라운드보드가 생성된다.")
  void racingRound() {
    int carCount = 2;
    int dummyNumber = 1;
    int round = 3;
    Racing racing = new Racing(carCount, round, new FixedNumberGenerator(dummyNumber));
    racing.racing();

    assertThat(racing.getRacingBoards()).hasSize(round);
  }

  @Test
  @DisplayName("랜덤 숫자가 4 미만일 때 자동차는 움직일 수 없다.")
  void cantmoveCar() {
    int carCount = 1;
    int randomNumber = 3;
    int round = 1;

    Racing racing = new Racing(carCount, round, new FixedNumberGenerator(randomNumber));
    boolean result = racing.isEnabledMove();
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("랜덤 숫자가 4 이상일 때 자동차는 움직일 수 있다.")
  void canmoveCar() {
    int carCount = 1;
    int randomNumber = 4;
    int round = 1;

    Racing racing = new Racing(carCount, round, new FixedNumberGenerator(randomNumber));
    boolean result = racing.isEnabledMove();
    assertThat(result).isTrue();
  }
}
