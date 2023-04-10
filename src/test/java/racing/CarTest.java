package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void 생성시점_포지션_0() {
    Car car = new Car();
    assertThat(car.position()).isEqualTo(0);
  }

  @Test
  void 움직일_수_있다() {
    Car car = new Car();
    car.move();
    assertThat(car.position()).isEqualTo(1);
  }

  @Test
  void 현재_자동차_위치_반환() {
    Car car = new Car();
    IntStream.range(0, 5)
        .forEach(i -> car.move());
    assertThat(car.position()).isEqualTo(5);
  }
}