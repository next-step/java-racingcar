package step3;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingGameUtilsTest {

  @ParameterizedTest
  @CsvSource({"3, false", "4, true"})
  @DisplayName("입력 숫자에 따라 움직임 가능 여부 판단")
  void isCanMove(int number, boolean expected) {
    assertThat(RacingGameUtils.isCanMove(number)).isEqualTo(expected);
  }

  @Test
  @DisplayName("0에서 9 사이의 정수 생성")
  void getRandomNumber() {
    Integer[] decimal = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    
    for (int i = 0; i < 1000; i++) {
      int number = RacingGameUtils.getRandomNumber();
      assertThat(decimal).contains(number);
      
      System.out.println(number);
    }
  }
}
