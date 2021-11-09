package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.strategy.MovingStrategy;

public class CarsTest {

  private final int numberOfCars = 3;
  private final int numberOfRounds = 4;

  @Test
  @DisplayName("자동차가 무조건 움직이는 조건일 경우, 주어진 횟수만큼 모든 자동차의 위치 변경 확인")
  void movableCarsPosition() {
    MovingStrategy movingStrategy = () -> true;

    Cars cars = moveCars(movingStrategy);

    cars.getCars()
        .forEach(car -> assertThat(car.getCurrentPosition()).isEqualTo(numberOfRounds));
  }

  @Test
  @DisplayName("자동차가 움직이지 않는 조건일 경우, 주어진 횟수만큼 경주 후 모든 자동차의 위치 유지 확인")
  void immovableCarsPosition() {
    MovingStrategy movingStrategy = () -> false;

    Cars cars = moveCars(movingStrategy);

    cars.getCars()
        .forEach(car -> assertThat(car.getCurrentPosition()).isEqualTo(0));
  }

  @Test
  @DisplayName("입력받은 자동차 대수와 레이싱 게임 후, 자동차 대수가 일치하는지 비교")
  void numberOfCarsAfterGame() {
    MovingStrategy movingStrategy = () -> true;

    Cars cars = moveCars(movingStrategy);

    assertThat(cars.getCars().size()).isEqualTo(numberOfCars);
  }

  private Cars moveCars(MovingStrategy movingStrategy) {
    Cars cars = new Cars(numberOfCars);

    for (int i = 0; i < numberOfRounds; i++) {
      cars.eachMove(movingStrategy);
    }
    return cars;
  }

}
