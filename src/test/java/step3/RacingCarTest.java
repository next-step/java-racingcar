package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

  @DisplayName("전진 테스트: Random에 대한 입력값이 4 이상일 때 전진")
  @ParameterizedTest
  @CsvSource({
    "0,0",
    "4,0",
    "5,1",
    "9,1",
  })
  void 전진_테스트 (int n, int expected) {
    assertThat(RacingCar.going(n)).isEqualTo(expected);
  }
}
