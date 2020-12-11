package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DistanceTest {

  @DisplayName("객체 생성 확인")
  @Test
  void constructorTest() {
    Distance distance = new Distance(2);
    assertThat(distance.get()).isEqualTo(2);
  }

  @DisplayName("distance를 증가시키는지 확인")
  @Test
  void moveTest() {
    Distance distance = new Distance(1);
    distance.move();
    assertThat(distance.get()).isEqualTo(2);
  }

  @DisplayName("0이하의 값을 할당할 경우 예외")
  @Test
  void exceptionTest() {
    assertThatThrownBy(() -> {
      new Distance(-1);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
