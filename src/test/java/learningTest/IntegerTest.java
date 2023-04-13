package learningTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerTest {

  @Test
  @DisplayName("parseInt() 실패시 예외를 반환한다")
  void parseIntExceptionTest() {
    String input = "three";

    Assertions.assertThatThrownBy(() -> Integer.parseInt(input))
        .isInstanceOf(NumberFormatException.class);
  }
}
