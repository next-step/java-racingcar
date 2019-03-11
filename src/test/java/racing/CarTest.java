package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CarTest {

  @Test
  public void test_move() {

    // Given
    Car car = new Car();

    // When
    car.move();

    // Then
    assertThat(car.getPosition()).isBetween(0, 1);
  }
}
