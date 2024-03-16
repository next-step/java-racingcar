package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.generator.RandomGenerator;

public class RacingCarsTest {

  RacingCars racingCars;

  @BeforeEach
  void setUp() {
    List<String> carNames = List.of("pobi", "crong", "honux");
    List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    racingCars = new RacingCars(cars);
  }

  @Test
  @DisplayName("레이싱 자동차의 수를 확인한다.")
  void getCarCount() {
    int carCount = racingCars.getCarCount();
    assertThat(carCount).isEqualTo(3);
  }

  @Test
  @DisplayName("레이싱 자동차 객체의 toString의 재정의 형식이 맞는지 확인한다.")
  void toStringTest() {
    String expected = "pobi : -*\ncrong : -*\nhonux : -*\n";
    assertThat(racingCars.toString()).matches(expected);
  }

  @Test
  @DisplayName("우승자는 1명 이상 있다.")
  void findWinners() {
    racingCars.move(new RandomGenerator(10));

    List<String> winners = racingCars.findWinners();

    assertThat(winners.size()).isGreaterThan(0);
  }


}
