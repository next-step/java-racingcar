package racingCar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

  @Test
  @DisplayName("자동차 이름은 5자를 초과할 수 없습니다.")
  void tooLongCarName() {
    assertThatThrownBy(() -> {
      CarName carName = new CarName("aaaaaaaaaaaaaaaa");
    }).isInstanceOf(RuntimeException.class);
  }

  @Test
  @DisplayName("자동차 이름은 null이거나 공백일 수 없습니다.")
  void carNameIsNotBlank() {
    assertThatThrownBy(() -> {
      CarName carName = new CarName(null);
    }).isInstanceOf(RuntimeException.class);
    assertThatThrownBy(() -> {
      CarName carName = new CarName(" ");
    }).isInstanceOf(RuntimeException.class);
  }
}