package racing.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

  @DisplayName("입력한 값이 0 인지 판단하는 검증로직 테스트")
  @Test
  void isZero() {
    //given
    Validation validation = new Validation();
    int[] carCountAndTurnCount = {0, 0};

    //when
    final Boolean isZero = validation.isZero(carCountAndTurnCount);

    //then
    assertFalse(isZero);
  }
}