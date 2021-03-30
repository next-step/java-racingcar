package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  @DisplayName("자동차의 위치 입력")
  @Test
  void stringCalculate() {
    // given
    int position = 2;

    // when
    Car car = new Car(position);

    // then
    assertThat(car.curPosition()).isEqualTo(2);
  }

}
