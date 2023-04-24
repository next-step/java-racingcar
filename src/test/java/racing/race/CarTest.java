package racing.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import racing.strategy.MoveNumberStrategy;
import racing.strategy.StopNumberStrategy;

class CarTest {

  @Test
  void 자동차이름은5자를초과할수없다() {
    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> {
          new Car("pobipobi", new MoveNumberStrategy());
        });
  }

  @Test
  void 자동차는멈출수있다() {
    Car car = new Car("stop", new StopNumberStrategy());
    car.move();

    assertThat(car.moveDistance()).isEqualTo(0);
  }

  @Test
  void 자동차는전진할수있다() {
    Car car = new Car("move", new MoveNumberStrategy());
    car.move();

    assertThat(car.moveDistance()).isEqualTo(1);
  }

}