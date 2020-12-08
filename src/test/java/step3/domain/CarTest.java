package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.service.RacingRule;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

  @DisplayName("Car객체 생성 시 distance 초기값이 1인지 확인한다.")
  @Test
  void initTest() {
    Car car = new Car();
    assertThat(car.getDistance()).isEqualTo(1);
  }

  @DisplayName("move 와 getDistance 가 잘 동작하는지 확인")
  @Test
  public void moveTest() {
    Car car = new Car();
    car.move();
    assertThat(car.getDistance()).isEqualTo(2);
  }

}
