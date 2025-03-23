package step4.carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PositionTest {

  @DisplayName("음수의 위치를 가지는 Position 객체 생성시 예외를 반환한다.")
  @Test
  void testCreatePositionWithNegativePosition() {
    int negativePosition = -1;

    assertThatThrownBy(() -> new Position(negativePosition))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("위치는 0 이상이어야 합니다.");
  }

  @DisplayName("position을 증가시키는 기능 테스트")
  @Test
  void testIncreasePosition() {
    Position position = new Position(0);
    position.increase(1);

    assertTrue(position.isSame(1));
  }

  @DisplayName("position의 값과 비교값 중 큰 값을 반환하는 기능 테스트")
  @Test
  void testGetMaxPosition() {
    Position position = new Position(0);
    int compareValue = 1;

    int maxPosition = position.getMax(compareValue);

    assertEquals(1, maxPosition);
  }

  @DisplayName("position의 상태를 문자열로 반환하는 기능 테스트")
  @Test
  void testGetPositionStatus() {
    Position position = new Position(3);

    assertEquals("----", position.getStatus());
  }
}