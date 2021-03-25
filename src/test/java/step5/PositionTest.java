package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.exception.IllegalPositionException;
import step5.model.Position;

public class PositionTest {
  @ParameterizedTest
  @ValueSource(ints = {-1,-2})
  @DisplayName("요소 내에서 빈 값이 입력된 경우 제대로 종료하는지 확인")
  void invalidPositionTest(int number){
    Assertions.assertThatThrownBy(() -> {
      new Position(number);
    }).isInstanceOf(IllegalPositionException.class)
      .hasMessage("적절하지 못한 위치입니다.");
  }
}
