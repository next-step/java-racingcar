package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

  Car car;
  @BeforeEach
  void setUp() {
    car = new Car();
  }

  @Test
  void 차의_처음_위치가_원점인지_확인() {
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @Test
  void 차가_움직이는지_확인(){
    car.move();
    assertThat(car.getPosition()).isIn(0, 1);
  }
}
