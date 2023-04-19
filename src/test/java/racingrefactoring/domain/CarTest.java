package racingrefactoring.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void 움직일_수_있는_경우() {
    MoveStrategy alwaysMoveStrategy = () -> true;

    Car car = new Car("car1");
    car.move(alwaysMoveStrategy);

    assertThat(car.getPosition()).isEqualTo(1);
  }

  @Test
  void 움직일_수_없는_경우() {
    MoveStrategy stopStrategy = () -> false;

    Car car = new Car("car1");
    car.move(stopStrategy);

    assertThat(car.getPosition()).isEqualTo(0);

  }

  @Test
  void isMaxPosition() {
    Car car = new Car("car1");
    car.move(() -> true);
    car.move(() -> true);
    car.move(() -> true);

    assertThat(car.isMaxPosition(3)).isTrue();
  }
}