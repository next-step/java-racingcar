package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.strategy.FixedFalseMovingStrategy;
import racingcar.strategy.FixedTrueMovingStrategy;
import racingcar.strategy.RandomMovingStrategy;

class CarTest {

  @Test
  @DisplayName("생성된 자동차 객체의 초기 위치 확인")
  void checkInitialPositionCreatedCarObject() {
    Car car = Car.create(new RandomMovingStrategy(), "pobi");

    assertThat(car.getCurrentPosition()).isZero();
  }

  @Test
  @DisplayName("자동차가 위치가 변경된 후 결과 확인")
  void checkPositionMovedCar() {
    Car car = Car.create(new FixedTrueMovingStrategy(), "pobi");

    car.move();

    assertThat(car.getCurrentPosition()).isOne();
  }

  @Test
  @DisplayName("자동차 위치가 변경되지 않는 경우")
  void checkPositionNotMovedCar() {
    Car car = Car.create(new FixedFalseMovingStrategy(), "pobi");

    car.move();

    assertThat(car.getCurrentPosition()).isZero();
  }

  @ParameterizedTest
  @DisplayName("자동차 저장된 이름 확인")
  @ValueSource(strings = {"pobi", "crong", "honux"})
  void checkSavedNames(String value) {
    Car car = Car.create(new FixedFalseMovingStrategy(), value);

    assertThat(car.getCarName()).isEqualTo(value);
  }

  @ParameterizedTest
  @DisplayName("자동차 위치 비교한 결과값 확인")
  @CsvSource({"1,3,-1", "1,1,0", "3,1,1"})
  void checkCarPositionCompareToResult(int onePosition, int twoPosition, int expected) {
    Car car1 = new Car(new FixedTrueMovingStrategy(), new CarName("pobi"),
        new Position(onePosition));
    Car car2 = new Car(new FixedTrueMovingStrategy(), new CarName("crong"),
        new Position(twoPosition));

    assertThat(car1.compareTo(car2)).isEqualTo(expected);
  }
}
