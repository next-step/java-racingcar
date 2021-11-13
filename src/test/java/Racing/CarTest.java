package Racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  @DisplayName("")
  void testMove() {
    // given
    Car car = new Car();
    // when
    car.move();
    // then
    assertThat(car.presentDistance()).isNotEmpty();
  }
}