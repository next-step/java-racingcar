package Racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingTest {

  @ParameterizedTest
  @DisplayName("레이싱 시작시 입력값에 맞게 출력합니다.")
  @CsvSource(value = {"3|5", "4|6", "6|7"}, delimiter = '|')
  void testRace(int countOfCar, int countOfStage) {
    // given
    // when
    String board = new Racing(countOfCar).run(countOfStage);
    // then
    String[] stages = board.split("\n\n");
    assertThat(stages.length).isEqualTo(countOfStage);
    for (String stage : stages) {
      String[] track = stage.split("\n");
      assertThat(track.length).isEqualTo(countOfCar);
    }
  }

}