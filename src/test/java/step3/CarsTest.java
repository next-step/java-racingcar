package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

  @DisplayName("주어진 숫자만큼 자동차를 생성")
  @Test
  void numberOf() {
    final int given = 3;
    Cars cars = new Cars(given);
    final int actual = cars.numberOf();

    assertThat(actual).isEqualTo(3);
  }
}