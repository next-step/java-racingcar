package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racing.exception.RacingException;

class CarsTest {
  @Test
  void parseCarNames(){
    List<Car> cars = Cars.from("a,b,c");
    assertThat(cars).hasSize(3);
    assertThat(cars).extracting(Car::getName)
        .containsExactly("a", "b", "c");
  }

  @Test
  void parseSingleCar() {
    List<Car> cars = Cars.from("a");
    assertThat(cars).hasSize(1);
  }

  @Test
  void trimWhitespace() {
    List<Car> cars = Cars.from("a ,b, ee");
    assertThat(cars).extracting(Car::getName)
        .containsExactly("a", "b", "ee");
  }

}