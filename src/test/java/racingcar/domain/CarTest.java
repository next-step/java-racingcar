package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
  public static final String CAR_NAME = "pobi";

  @DisplayName("자동차가 전진 조건일때 전진한다")
  @Test
  void carMovesForward() {

    Car car = new Car(CAR_NAME);
    car.move(() -> true);

    assertThat(car.getPosition()).isEqualTo(1);
  }

  @DisplayName("자동차가 정지 조건일때 멈춰있는다")
  @Test
  void carMovesStop() {
    Car car = new Car(CAR_NAME);
    car.move(() -> false);

    assertThat(car.getPosition()).isEqualTo(0);
  }


  @DisplayName("Position 값으로 Car 객체의 우열을 가릴 수 있다.")
  @ParameterizedTest
  @CsvSource({
          "1, 1, 0",
          "3, 1, 1",
          "1, 3, -1",
  })
  void compareTo(int pobiCarPosition, int jasonCarPosition, int expected) {
    Car pobiCar = new Car("pobi", new Position(pobiCarPosition));
    Car jasonCar = new Car("jason", new Position(jasonCarPosition));

    assertThat(pobiCar.compareTo(jasonCar)).isEqualTo(expected);
  }

  @Test
  @DisplayName("두 Car가 같은 포지션일 때 isSamePosition()은 true를 반환한다.")
  void samePositionTrue() {
    Car pobiCar = new Car("pobi", new Position(3));
    Car jasonCar = new Car("jason", new Position(3));

    assertThat(pobiCar.isSamePosition(jasonCar)).isTrue();
  }

  @Test
  @DisplayName("두 Car가 서로 다른 포지션일 때 isSamePosition()은 false를 반환한다.")
  void samePositionFalse() {
    Car pobiCar = new Car("pobi", new Position(5));
    Car jasonCar = new Car("jason", new Position(3));

    assertThat(pobiCar.isSamePosition(jasonCar)).isFalse();
  }
}
