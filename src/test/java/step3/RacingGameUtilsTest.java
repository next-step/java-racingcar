package step3;

import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameUtilsTest {

  @ParameterizedTest
  @CsvSource({"3, false", "4, true"})
  void isCanMove(int randomNumber, boolean expected) {
    assertThat(RacingGameUtils.isCanMove(randomNumber)).isEqualTo(expected);
  }

  @Test
  void getRandomNumber() {
    Integer[] decimal = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    
    for (int i = 0; i < 1000; i++) {
      assertThat(decimal).contains(RacingGameUtils.getRandomNumber());
    }
  }
}
