package Racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingTest {

  @ParameterizedTest
  @DisplayName("레이싱 시작시 입력값에 맞게 출력합니다.")
  @CsvSource(value = {"3|5", "4|6", "6|7"}, delimiter = '|')
  void testRace(int countOfCar, int countOfTry) {
    // given
    // when
    String result = new Racing().run(countOfCar, countOfTry);
    // then
    String[] split = result.split("\n\n");
    assertThat(split.length).isEqualTo(countOfTry);
    for (String s : split) {
      String[] split1 = s.split("\n");
      assertThat(split1.length).isEqualTo(countOfCar);
    }
  }

}