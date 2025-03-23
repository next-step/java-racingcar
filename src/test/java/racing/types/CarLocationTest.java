package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarLocationTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    assertDoesNotThrow(CarLocation::new);
  }

  @DisplayName("생성자 테스트2")
  @Test
  void constructorTest2() {
    assertDoesNotThrow(() -> CarLocation.valueOf(2));
  }

  @DisplayName("생성자 테스트3")
  @Test
  void constructorTest3() {
    assertDoesNotThrow(() -> CarLocation.valueOf(CarLocation.valueOf(4)));
  }

  @DisplayName("전진 시 위치 테스트")
  @Test
  void testGetNextLocation() {
    CarLocation carLocation = new CarLocation();

    assertThat(carLocation.getNextLocation()).isEqualTo(CarLocation.valueOf(1));
  }
}
