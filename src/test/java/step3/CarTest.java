package step3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class CarTest {
  Car car = new Car();

  @Test
  void move() {
    car.move();
    assertThat(car.getDistance()).isEqualTo(1);
  }

  @Test
  void getDistance() {
    assertThat(car.getDistance()).isEqualTo(0);
  }
}
