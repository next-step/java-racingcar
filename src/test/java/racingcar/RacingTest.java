package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.random.RandomNumberGenerator;

class RacingTest {

  @Test
  @DisplayName("입력한 자동차 이름만큼 자동차가 초기화 된다.")
  void createCars() {
    List<String> carNames = new ArrayList<>();
    carNames.add("pobi");
    carNames.add("crong");
    int dummyNumber = 1;

    List<Car> carList = carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());

    Cars cars = new Cars(carList);
    Racing racing = new Racing(cars, new FixedNumberGenerator(dummyNumber));

    assertThat(racing.getCars().size()).isEqualTo(carNames.size());
  }

  @Test
  @DisplayName("랜덤 숫자가 4 미만일 때 자동차는 움직일 수 없다.")
  void cantmoveCar() {
    List<String> carNames = new ArrayList<>();
    carNames.add("pobi");
    int randomNumber = 3;

    List<Car> carList = carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());

    Cars cars = new Cars(carList);
    Racing racing = new Racing(cars, new FixedNumberGenerator(randomNumber));
    Cars result = racing.start();
    assertThat(result.get(0).getPosition()).isEqualTo(0);
  }

  @Test
  @DisplayName("랜덤 숫자가 4 이상일 때 자동차는 움직일 수 있다.")
  void canmoveCar() {
    List<String> carNames = new ArrayList<>();
    carNames.add("pobi");
    int randomNumber = 4;

    List<Car> carList = carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());

    Cars cars = new Cars(carList);
    Racing racing = new Racing(cars, new FixedNumberGenerator(randomNumber));
    Cars result = racing.start();
    assertThat(result.get(0).getPosition()).isEqualTo(1);
  }



}
