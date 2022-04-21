package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DistanceTest {

  @Test
  @DisplayName("동일한 거리를 가진 클래스가 동일한지 확인")
  void create() {
    Distance distance = new Distance(3);
    assertThat(distance).isEqualTo(new Distance(3));
  }

  @Test
  @DisplayName("음수의 거리 클래스 생성 시 에러")
  void minusDistance() {
    assertThatThrownBy(() -> {
      new Distance(-1);
    });
  }

  @ParameterizedTest
  @DisplayName("Distance 값 증가 확인")
  @ValueSource(ints = {1, 5, 100})
  void increase(int amount) {
    Distance distance = new Distance(0);

    for (int i = 0; i < amount; i++) {
      distance.increase();
    }

    assertThat(distance).isEqualTo(new Distance(amount));
  }
}
