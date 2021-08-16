package step45.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  @ParameterizedTest(name = "Car {0}회 전진 테스트")
  @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
  void goTest(int distance) {
    //given
    Car car = new Car("test");

    //when
    car.move(distance);

    //then
    assertThat(car.getLocation()).isBetween(0, distance);
  }

  @ParameterizedTest(name = "Car 이름확인 테스트 {0}")
  @ValueSource(strings = {"pobi", "crong", "honux"})
  void carNameTest(String name) {
    //given
    Car car = new Car(name);

    //then
    assertEquals(name, car.getName());
  }

  @ParameterizedTest(name = "Car 5글자 초과이름 예외발생 테스트 {0}")
  @ValueSource(strings = {"pobiii", "cronggg", "honuxxxxxx"})
  void carNameExceptionTest(String name) {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Car(name);
    });
  }
}
