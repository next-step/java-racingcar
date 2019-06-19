package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RefereeTest {

  @Test
  public void 포지션이가장큰사람이_우승() {
    String[] names = {"name1", "name2", "name3"};
    Cars cars = new Cars(names);

    cars.moveCars();
    List<Car> racingCars = cars.moveCars();
    Car car = racingCars.stream().max(Comparator.comparingInt(Car::getPosition)).get();
    String winner = car.getName();

    assertThat(Referee.announceWinner(cars)).contains(winner);

  }

}
