package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.Car;
import study.step3.domain.CarMovableStrategy;
import study.step3.domain.MovableStrategy;

public class CarTest {

  @DisplayName("자동차의 위치 입력")
  @Test
  void carInitPositionTest() {
    // given
    int position = 2;

    // when
    Car car = new Car(position);

    // then
    assertThat(car.curPosition()).isEqualTo(2);
  }

  @DisplayName("자동차가 이동할 때 문자열 이동경로 생성")
  @Test
  void carPathWhenMove() {
    // given
    MovableStrategy movableStrategy = new CarMovableStrategy();
    int position = 1;

    Car movedCar = new Car(position);

    // when
    Car newCar = new Car(movableStrategy);
    newCar.move();

    // then
    assertThat(newCar.equals(movedCar)).isTrue();
  }

  @DisplayName("자동차가 이동 실패했을 때 문자열 이동경로가 null인지")
  @Test
  void carPathNullWhenMove() {
    // given
    MovableStrategy movableStrategy = new CarMovableStrategy();
    Car movedCar = new Car();

    // when
    Car newCar = new Car(movableStrategy);
    newCar.move();

    // then
    assertThat(newCar.equals(movedCar)).isTrue();
  }

}
