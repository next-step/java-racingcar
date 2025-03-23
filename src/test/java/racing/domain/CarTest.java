package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

public class CarTest {

  Car car = new Car("pobi");

  @Test
  void 자동차_멈춤() {
    car.driveOrStop(3);
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @Test
  void 자동차_전진() {
    car.driveOrStop(4);
    assertThat(car.getPosition()).isEqualTo(1);
  }

  @Test
  void 랜덤값_0미만_예외_발생() {
    assertThatThrownBy(() -> car.driveOrStop(-1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("랜덤 값은 0에서 9 사이여야 합니다.");
  }

  @Test
  void 랜덤값_최대초과_예외_발생() {
    assertThatThrownBy(() -> car.driveOrStop(10))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("랜덤 값은 0에서 9 사이여야 합니다.");
  }

  @Test
  void 자동차_이름_5글자_초과() {
    assertThatThrownBy(() -> new Car("longname"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
  }
}

