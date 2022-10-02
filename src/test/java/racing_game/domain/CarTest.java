package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
    int distance = car.getDistance().toInt();
    assertThat(distance).isGreaterThanOrEqualTo(0);
  }
}
