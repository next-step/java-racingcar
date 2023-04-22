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
  void 최대_위치인_경우() {
    Car car = new Car("car1", 3);

    Position maxPosition = new Position(3);

    assertThat(car.isMaxPosition(maxPosition)).isTrue();
  }

  @Test
  void 최대_위치가_아닌_경우() {
    Car car = new Car("car1", 2);

    Position maxPosition = new Position(3);

    assertThat(car.isMaxPosition(maxPosition)).isFalse();
  }
}