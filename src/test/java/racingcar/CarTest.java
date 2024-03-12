package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
  private Car car;

  @BeforeEach
  void beforeEach() {
    this.car = new Car();
  }

  @Test
  void 초기_위치_값으로_생성() {
    Car car = new Car(10);
    assertThat(car.isLocationValueOf(10)).isTrue();
  }

  @Test
  void 입력이_4보다_크거나_같으면_전진() {
    car.moveConditionally(4);
    assertThat(car.isLocationValueOf(1)).isTrue();
  }

  @Test
  void 입력이_4보다_작으면_정지() {
    car.moveConditionally(3);
    assertThat(car.isLocationValueOf(0)).isTrue();
  }

  @Test
  void 위치_나타내는_문자열_생성() {
    final String DISTANCE_UNIT = "-";
    car.moveConditionally(8);
    car.moveConditionally(9);
    assertThat(car.trace(DISTANCE_UNIT)).isEqualTo("--");
  }

  @Test
  void 더_멀리_있다() {
    car.moveConditionally(9);
    assertThat(car.furtherThan(new Car())).isTrue();
  }

  @Test
  void 더_가까이_있다() {
    assertThat(car.closerThan(new Car(3))).isTrue();
  }
}
