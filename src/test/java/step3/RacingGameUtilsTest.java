package step3;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameUtilsTest {

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
