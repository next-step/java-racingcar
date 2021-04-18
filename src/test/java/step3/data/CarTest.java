package step3.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

  private Car car;

  @BeforeEach
  void setUp(){
    car = new Car();
  }
  @Test
  public void moveTest() {
    assertThat(car.move(1)).isFalse();
    assertThat(car.move(4)).isTrue();
    assertThat(car.move(8)).isTrue();
  }
}
