package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void create() {
    Car car = Car.create();
    assertThat(car).isNotNull();
  }

  @Test
  void move() {
    Car car = Car.create();
    car.move();
    int distance = car.getDistance(1);
    assertThat(distance).isGreaterThanOrEqualTo(0);

    assertThatThrownBy(() -> car.getDistance(2)).isInstanceOf(RuntimeException.class);
  }

  @Test
  void getCurrentDistance() {
    Car car = Car.create();
    car.move();
    car.move();
    car.move();
    car.move();
    int distance1 = car.getDistance(4);
    int distance2 = car.getCurrentDistance();
    assertThat(distance1).isEqualTo(distance2);
  }
}
