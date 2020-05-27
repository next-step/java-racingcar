package racing_game.model;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing_game.model.Car;
import racing_game.model.RacingCarFactory;
import racing_game.model.RacingCarMovingStrategy;

public class RacingCarFactoryTest {
  @ParameterizedTest
  @ValueSource(ints = {1})
  @DisplayName("횟수에 따라 자동차 인스턴스 생성")
  void createRacingCarList(int numberOfCars) {
    List<Car> racingCarList = RacingCarFactory.createRacingCarList(numberOfCars);

    for (Car car : racingCarList) {
      assertThat(car)
          .isEqualToComparingFieldByFieldRecursively(new Car("", new RacingCarMovingStrategy()));
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"name1, name2, name3"})
  @DisplayName("자동차 이름 배열의 개수 만큼 인스턴스 생성")
  void createRacingCarListWithCarName(String carNameInput) {
    String[] carNameArr = carNameInput.split(",");
    List<Car> racingCarList = RacingCarFactory.createRacingCarList(carNameArr);

    for (int i = 0; i < carNameArr.length; i++) {
      assertThat(racingCarList.get(i)).isEqualToComparingFieldByFieldRecursively(
          new Car(carNameArr[i], new RacingCarMovingStrategy()));
    }
  }
}
