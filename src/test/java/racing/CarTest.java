package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;

class CarTest {

  @Test
  void 생성시점_포지션_0() {
    Car car = new Car();
    assertThat(car.position()).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 5})
  void 자동차_움직임(int number) {
    Car car = new Car();
    car.move(number);
    assertThat(car.position()).isEqualTo(1);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void 자동차_정지(int number) {
    Car car = new Car();
    car.move(number);
    assertThat(car.position()).isEqualTo(0);
  }


}