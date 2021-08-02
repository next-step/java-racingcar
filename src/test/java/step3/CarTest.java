package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  @ParameterizedTest(name = "Car {0}회 전진 테스트")
  @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
  void goTest(int num) {
    //given
    Car car = new Car(new RandomMoveStrategy());

    //when
    for (int i = 0; i < num; i++) {
      car.move();
    }

    //then
    assertThat(car.getLocation()).isBetween(0, num);
  }
}
