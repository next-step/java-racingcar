package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Referee;

public class RefereeTest {

  @Test
  public void 포지션이가장큰사람이_우승() {
    Car car = generatePositionedCar("car1", 0);
    Car car1 = generatePositionedCar("car2", 0);
    Car car2 = generatePositionedCar("car3", 1);

    Cars cars = generateCars(car,car1,car2);

    assertThat(Referee.announceWinners(cars)).contains("car3");

  }

  @Test
  public void 공동우승확인() {
    Car car = generatePositionedCar("car1", 0);
    Car car1 = generatePositionedCar("car2", 1);
    Car car2 = generatePositionedCar("car3", 1);

    Cars cars = generateCars(car,car1,car2);;

    assertThat(Referee.announceWinners(cars)).contains("car2","car3");

  }

  public Car generatePositionedCar(String name, int position) {
    Car resultCar = new Car(name);
    for (int i = 0; i < position; i++) {
      resultCar.move(9);
    }
    return resultCar;
  }

  public Cars generateCars(Car ... car) {
    return new Cars(Arrays.asList(car));
  }

}
