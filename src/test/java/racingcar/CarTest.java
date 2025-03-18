package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  @DisplayName("자동차는 전진할 수 있다.")
  void move() {
    String name = "pobi";
    Car car = new Car(name);
    car.move();
    assertThat(car.getPosition()).isEqualTo(1);
  }

  @Test
  @DisplayName("자동차는 5자 이상의 이름을 가질 경우 IllegalArgumentException 예외를 발생시킨다.")
  void validateName() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Car("abcdef"));
  }

  @Test
  @DisplayName("자동차는 이름을 가질 수 있다.")
  void getName() {
    String name = "pobi";
    Car car = new Car(name);
    assertThat(car.getName()).isEqualTo(name);
  }

}
