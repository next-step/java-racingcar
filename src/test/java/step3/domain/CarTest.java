package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

  @DisplayName("move 와 getDistance 가 잘 동작하는지 확인")
  @Test
  public void moveAndGetDistanceTest() {
    Car car = new Car();
    car.move();
    assertThat(car.getDistance()).isEqualTo(Car.INIT_POSITION + 1);
  }
}
