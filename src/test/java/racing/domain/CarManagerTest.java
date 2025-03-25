package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarManagerTest {

  @Test
  void 자동차_객체_생성() {
    String[] carNames = {"pobi", "crong", "honux"};
    assertThat(new CarManager(carNames, new RandomGenerator()).getCars().size()).isEqualTo(3);

  }

  @Test
  void 우승자_구하기() {
    Car pobi = new Car("pobi", 3);
    Car jason = new Car("jason", 1);
    Car brown = new Car("brown", 2);

    List<Car> cars = List.of(pobi, jason, brown);

    CarManager carManager = new CarManager(cars);

    List<String> winners = carManager.findWinners();

    assertThat(winners).containsExactlyInAnyOrder("pobi");
  }

  @Test
  void 경기후_결과_테스트_멈춤_케이스() {
    Car pobi = new Car("pobi");
    Car jason = new Car("jason");
    Car brown = new Car("brown");

    List<Car> cars = List.of(pobi, jason, brown);

    CarManager carManager = new CarManager(cars, new FixedNumberGenerator(2));
    carManager.simulateRace();

    for (Car car : cars) {
      assertEquals(0, car.getPosition());
    }
  }

  @Test
  void 경기후_결과_테스트_이동_케이스() {
    Car pobi = new Car("pobi");
    Car jason = new Car("jason");
    Car brown = new Car("brown");

    List<Car> cars = List.of(pobi, jason, brown);

    CarManager carManager = new CarManager(cars, new FixedNumberGenerator(5));
    carManager.simulateRace();

    for (Car car : cars) {
      assertTrue(car.getPosition() > 0);
    }
  }

}