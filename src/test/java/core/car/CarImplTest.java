package core.car;

import static org.assertj.core.api.Assertions.assertThat;

import core.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarImplTest {

  Util util = new Util();
  CarInterface carImpl = new CarImpl(util);

  @Test
  @DisplayName("자동차 생성 성공")
  void createCarSuccess() {
    // given
    Car car = carImpl.createCar("pobi", 0);
    // when
    Car expected = new Car("pobi", 0);
    // then
    assertThat(car).isEqualToComparingFieldByField(expected);
  }

  @Test
  @DisplayName("자동차 이동 않함")
  void goForwardFail() {
    // given
    Car car = carImpl.createCar("pobi", 0);
    // when
    carImpl.goForward(car, 0);
    Car expected = new Car("pobi", 0);
    // then
    assertThat(car).isEqualToComparingFieldByField(expected);
  }

  @Test
  @DisplayName("자동차 이동 성공")
  void goForwardSuccess() {
    // given
    Car car = carImpl.createCar("pobi", 0);
    // when
    carImpl.goForward(car, 5);
    Car expected = new Car("pobi", 1);
    // then
    assertThat(car).isEqualToComparingFieldByField(expected);
  }

  @Test
  @DisplayName("이동한 거리 문자열 출력 성공")
  void getDistanceWithString() {
    // given
    Car car = carImpl.createCar("pobi", 5);
    // when
    String result = carImpl.getDistanceWithString(car);
    String expected = "-----";
    // then
    assertThat(result).isEqualTo(expected);
  }
}
