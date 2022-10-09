package racingCar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.strategy.TestMovingStrategy;
import racingcar.domain.Car;
import racingcar.domain.strategy.MovingStrategy;

public class CarTest {

  @Test
  @DisplayName("차량 글자 수 5 초과 시 오류")
  void testBadName() {
    assertThrows(IllegalArgumentException.class,
        () -> new Car("tooLongName"));
  }

  @Test
  @DisplayName("2회 이동 시 위치값이 2")
  void testCarPostion() {
    Car car = new Car("car1");
    MovingStrategy movingStrategy = new TestMovingStrategy();
    for (int i = 0; i < 2; i++) {
      if (movingStrategy.isMoveAble()) {
        car.move();
      }
    }
    assertThat(car.getCarPosition()).isEqualTo(2);
  }

  @Test
  @DisplayName("랜덤값이 4 미만으로 이동하지 않았을 때 위치값이 0")
  void testCarPosition2() {
    Car car = new Car("car2");
    MovingStrategy movingStrategy = new MovingStrategy() {
      @Override
      public boolean isMoveAble() {
        return false;
      }
    };
    for (int i = 0; i < 2; i++) {
      if (movingStrategy.isMoveAble()) {
        car.move();
      }
    }
    assertThat(car.getCarPosition()).isEqualTo(0);
  }
}
