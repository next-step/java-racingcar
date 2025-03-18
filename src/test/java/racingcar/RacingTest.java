package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

  @Test
  @DisplayName("입력한 자동차 수만큼 자동차가 초기화 된다.")
  void createCars() {
    int carCount = 5;
    int dummyNumber = 1;
    Racing racing = new Racing(carCount, new FixedNumberGenerator(dummyNumber));
    assertThat(racing.getCars()).hasSize(carCount);
  }

  @Test
  @DisplayName("랜덤 숫자가 4 미만일 때 자동차는 움직일 수 없다.")
  void cantmoveCar() {
    int carCount = 1;
    int randomNumber = 3;

    Racing racing = new Racing(carCount, new FixedNumberGenerator(randomNumber));
    List<Car> result = racing.start();
    assertThat(result.get(0).getPosition()).isEqualTo(0);
  }

  @Test
  @DisplayName("랜덤 숫자가 4 이상일 때 자동차는 움직일 수 있다.")
  void canmoveCar() {
    int carCount = 1;
    int randomNumber = 4;

    Racing racing = new Racing(carCount, new FixedNumberGenerator(randomNumber));
    List<Car> result = racing.start();
    assertThat(result.get(0).getPosition()).isEqualTo(1);
  }
}
