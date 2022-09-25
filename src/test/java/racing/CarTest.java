package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  void move() {
    Car car = new Car();
    int carLastLocation = car.getLocation();
    car.move();
    assertThat(car.getLocation()).isEqualTo(carLastLocation + 1);
  }
}
