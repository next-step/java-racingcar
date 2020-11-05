package racinggame.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racinggame.vo.CarSateInRace;

class MovingResultTest {

  private static Stream<Arguments> provideMovingResult() {
    MovingResult oneWinner = new MovingResult(Arrays.asList(new CarSateInRace("a", 0),
        new CarSateInRace("b", 1),
        new CarSateInRace("c", 0)));

    MovingResult twoWinner = new MovingResult(Arrays.asList(new CarSateInRace("a", 1),
        new CarSateInRace("b", 1),
        new CarSateInRace("c", 0)));

    MovingResult threeWinner = new MovingResult(Arrays.asList(new CarSateInRace("a", 1),
        new CarSateInRace("b", 1),
        new CarSateInRace("c", 1)));

    return Stream.of(
        Arguments.of(oneWinner, "b"),
        Arguments.of(twoWinner, "a,b"),
        Arguments.of(threeWinner, "a,b,c")
    );
  }

  @ParameterizedTest
  @MethodSource("provideMovingResult")
  @DisplayName("경주 결과에 따라서 우승자 이름이 제대로 출력하는가?")
  void getWinnerCarNamesSuccessTest(MovingResult movingResult, String winnerResult) {
    assertThat(movingResult.getWinnerCarNames()).isEqualTo(winnerResult);
  }

  @Test
  @DisplayName("경주 진행 결과가 없을때 IllegalStateException를 던지는가?")
  void getWinnerCarNamesFailTest() {
    MovingResult movingResult = new MovingResult(Collections.EMPTY_LIST);
    assertThrows(IllegalStateException.class, () -> movingResult.getWinnerCarNames());
  }
}