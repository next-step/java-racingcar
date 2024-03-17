package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

  @Test
  void 초기_위치_값으로_생성() {
    Car car = new Car(10);
    assertThat(car.isLocatedAt(10)).isTrue();
  }

  @Test
  void 입력이_4보다_크거나_같으면_전진() {
    Car car = new Car();
    car.moveConditionally(new Condition(4));
    assertThat(car.isLocatedAt(1)).isTrue();
  }

  @Test
  void 입력이_4보다_작으면_정지() {
    Car car = new Car();
    car.moveConditionally(new Condition(3));
    assertThat(car.isLocatedAt(0)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = { "-:--", "*:**", "^:^^" }, delimiter = ':')
  void 위치_나타내는_문자열_생성(String distanceUnit, String expected) {
    Car car = new Car(2);

    assertThat(car.trace(distanceUnit)).isEqualTo(expected);
  }

  @Test
  void 더_멀리_있다() {
    Car car = new Car(9);

    assertThat(car.furtherThan(new Car(5))).isTrue();
  }

  @Test
  void 더_가까이_있다() {
    Car car = new Car();

    assertThat(car.closerThan(new Car(3))).isTrue();
  }
}
