package camp.nextstep.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  @DisplayName("위치 객체 생성")
  void givenNumber_shouldCreatedPosition() {
    assertThat(new Position(1)).isEqualTo(new Position(1));
  }

  @Test
  @DisplayName("위치 객체 음수 값 예외")
  void givenNegativeNumber_shouldException() {
    assertThatThrownBy(() -> new Position(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }

}