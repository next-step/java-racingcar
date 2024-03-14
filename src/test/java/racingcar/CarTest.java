package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

  Car car;

  @BeforeEach
  public void setUp() {
    car = new Car();
  }

  @Test
  public void initTest() {
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @Test
  public void moveTest() {
    car.move();
    assertThat(car.getPosition()).isEqualTo(1);
  }

}
