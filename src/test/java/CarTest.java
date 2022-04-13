import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  void Car_이동_성공() {
    Car car = new Car();
    car.move(9);
    assertThat(car.getPosition()).isEqualTo(9);
  }

  @Test
  void Car_이동_실패() {
    Car car = new Car();
    car.move(3);
    assertThat(car.getPosition()).isEqualTo(0);
  }
}
