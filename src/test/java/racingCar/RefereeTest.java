package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

  private Referee referee;

  @BeforeEach
  void setUp() {
    referee = new Referee();
  }

  @DisplayName("우승자 한명인 경우")
  @Test
  void te() {
    Car a = new Car("a", 1);
    Car b = new Car("b", 2);
    Car c = new Car("c", 3);
    List<Car> cars = Arrays.asList(a, b, c);

    List<Car> winners = referee.determineWinners(cars);
    assertThat(winners).contains(c);
  }

  @DisplayName("우승자 여러명인 경우")
  @Test
  void winner_more_two() {
    Car a = new Car("a", 1);
    Car b = new Car("b", 2);
    Car c = new Car("c", 4);
    Car d = new Car("c", 4);
    List<Car> cars = Arrays.asList(a, b, c, d);

    Referee referee = new Referee();
    List<Car> winners = referee.determineWinners(cars);
    assertThat(winners).contains(c, d);
  }


}