package study.step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step4.model.RacingGame;
import study.step4.model.car.Car;
import study.step4.exception.CarGameArgumentException;

public class CarTest {

  @DisplayName("자동차 이름 길이 제한 성공 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"car1", "car1,car2", "car1,car2,car3"})
  public void carNameLenghthSuccessTest(String carNames) {
    final int carGameRound = 5;
    assertDoesNotThrow(() -> new RacingGame(carNames, carGameRound));
  }

  @DisplayName("자동차 이름 길이 제한 실패 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"car123", "car123,car234", "car123,car234,car345"})
  public void carNameLenghthFailTest(String carNames) {
    final int carGameRound = 5;
    assertThrows(CarGameArgumentException.class, () -> new RacingGame(carNames, carGameRound));
  }

  @DisplayName("자동차 move success 테스트")
  @Test
  public void carMoveSuccessTest() {

    Car car1 = new Car("car1", 1);
    car1.move(() -> true);

    Car car2 = new Car("car2", 2);
    car2.move(() -> true);

    Car car3 = new Car("car3", 3);
    car3.move(() -> true);

    assertThat(car1).isEqualByComparingTo(new Car(car1.getName(), 2));
    assertThat(car2).isEqualByComparingTo(new Car(car2.getName(), 3));
    assertThat(car3).isEqualByComparingTo(new Car(car3.getName(), 4));
  }

  @DisplayName("자동차 move fail 테스트")
  @Test
  public void carMoveFailTest() {

    Car car1 = new Car("car1", 1);
    car1.move(() -> false);

    Car car2 = new Car("car2", 2);
    car2.move(() -> false);

    Car car3 = new Car("car3", 3);
    car3.move(() -> false);

    assertThat(car1).isEqualByComparingTo(new Car(car1.getName(), 1));
    assertThat(car2).isEqualByComparingTo(new Car(car2.getName(), 2));
    assertThat(car3).isEqualByComparingTo(new Car(car3.getName(), 3));
  }
}
