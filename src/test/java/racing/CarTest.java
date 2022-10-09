package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  private static Car car;

  @BeforeEach
  void setUp() {
    car = new Car();
  }

  @Test
  @DisplayName("자동차를 한칸 이동시킨다")
  void moveOnce() {
    int carLastLocation = car.nowLocation();
    car.move();
    assertThat(car.nowLocation()).isEqualTo(carLastLocation + 1);
  }
}
