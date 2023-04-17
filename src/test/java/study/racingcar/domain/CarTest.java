package study.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.factory.CarFactory;

public class CarTest {

  @DisplayName("자동차는 랜덤하게 1칸 전진하거나 전진하지 않는다.")
  @Test
  public void move_forwardOrStop() {
    Car car = CarFactory.createCar("test");

    car.move();

    assertThat(car.getDistance()).isLessThanOrEqualTo(1);
  }

  @DisplayName("경쟁 자동차와 거리를 비교하여 승자를 판단한다.")
  @Test
  public void isWinner_True_CompetitorCar(){
    Car car = CarFactory.createCar("test");
    Car competitor = CarFactory.createCar("competitor");

    car.move();

    assertThat(car.isWinner(competitor)).isTrue();
  }
}
