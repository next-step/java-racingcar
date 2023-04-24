package racing.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.strategy.MoveNumberStrategy;
import racing.strategy.StopNumberStrategy;

class CarsTest {

  Cars cars;
  private static final int CAR_NUMBER = 3;
  private static final int TRY_NUMBER = 5;

  @BeforeEach
  public void init() {
    cars = new Cars("pobi,crong,honux");
  }

  @Test
  void 우승자는0명일수없다() {
    List<Car> winners = cars.race(TRY_NUMBER);

    assertThat(winners.size()).isGreaterThan(0);
  }

  @Test
  void 우승자한명구하기() {
    Car yeCar = new Car("yecar", new MoveNumberStrategy());
    yeCar.move();
    yeCar.move();
    yeCar.move();
    Car juCar = new Car("jucar", new StopNumberStrategy());
    juCar.move();
    Cars cars = new Cars(Arrays.asList(yeCar, juCar));

    List<Car> winners = new Winners().findWinner(3, cars);

    assertThat(winners).contains(yeCar);
  }

  @Test
  void 우승자두명구하기() {
    Car yeCar = new Car("yecar", new MoveNumberStrategy());
    yeCar.move();
    yeCar.move();
    yeCar.move();
    Car juCar = new Car("jucar", new MoveNumberStrategy());
    juCar.move();
    juCar.move();
    juCar.move();
    Car siCar = new Car("sicar", new StopNumberStrategy());
    siCar.move();
    siCar.move();
    Cars cars = new Cars(Arrays.asList(yeCar, juCar, siCar));

    List<Car> winners = new Winners().findWinner(3, cars);

    assertThat(winners).contains(yeCar);
    assertThat(winners).contains(juCar);
  }

  @Test
  void 이동횟수는음수를입력할수없다() {
    assertThatExceptionOfType(NumberFormatException.class)
        .isThrownBy(() -> cars.race(-1));
  }

  @Test
  void 자동차생성할수있다() {
    assertThat(cars.getGameCars().size()).isEqualTo(CAR_NUMBER);
  }

}