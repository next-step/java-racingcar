package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.Car;
import study.step3.factory.CarFactory;

public class CarTest {

  @DisplayName("자동차는 랜덤하게 1칸 전진하거나 전진하지 않는다.")
  @Test
  public void move_forwardOrStop() {
    Car car = CarFactory.createCar();

    car.randomMove();

    assertThat(car.getDistance()).isLessThanOrEqualTo(1);
  }
}
