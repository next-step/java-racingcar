package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    assertDoesNotThrow(Car::new);
  }

  @DisplayName("생성자 테스트2")
  @Test
  void constructorTest2() {
    assertDoesNotThrow(() -> Car.valueOf(new Car()));
  }

  @DisplayName("생성자 테스트3")
  @Test
  void constructorTest3() {
    assertDoesNotThrow(() -> Car.valueOf(CarName.valueOf("test")));
  }

  @DisplayName("전략에 따라 차를 이동한다.")
  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void testToMovingCar(boolean strategyResult) {
    int simulateCount = 4;
    Car result = Car.valueOf(CarName.valueOf("test"));
    Car expected = strategyResult ? Car.valueOf(CarName.valueOf("test"), CarLocation.valueOf(4)) : Car.valueOf(CarName.valueOf("test"));

    for (int i = 0; i < simulateCount; i++) {
      result = result.toMovingCar(() -> strategyResult);
    }


    assertThat(result).isEqualTo(expected);
  }

  @DisplayName("차들의 이름을 문자열로 가져옴")
  @Test
  void testToNameString() {
    List<Car> input = List.of(
        Car.valueOf(CarName.valueOf("a")),
        Car.valueOf(CarName.valueOf("b"))
    );

    assertThat(Car.toNameString(input)).isEqualTo("a, b");
  }

  @DisplayName("차들의 위치를 문자열로 가져옴 (차 이름이 있을 때)")
  @Test
  void testToLocationStringWithNamedCar() {
    List<Car> input = List.of(
        Car.valueOf(CarName.valueOf("a"), CarLocation.valueOf(1)),
        Car.valueOf(CarName.valueOf("b"), CarLocation.valueOf(2))
    );

    assertThat(Car.toLocationString(input)).isEqualTo("a:-\nb:--\n");
  }

  @DisplayName("차들의 위치를 문자열로 가져옴 (차 이름이 없을 때)")
  @Test
  void testToLocationStringUnNamedCar() {
    List<Car> input = List.of(
        Car.valueOf(CarLocation.valueOf(1)),
        Car.valueOf(CarLocation.valueOf(2))
    );

    assertThat(Car.toLocationString(input)).isEqualTo("-\n--\n");
  }
}
