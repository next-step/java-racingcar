package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.racingGame.Car;
import study.domain.racingGame.CarCondition;

public class CarTest {

  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car();
  }

  @DisplayName("차량 움직이는 지 태스트")
  @Test
  public void moveTest() {
    car.move();
    assertThat(car.findTotalDistance()).isLessThanOrEqualTo(1);
  }
}
