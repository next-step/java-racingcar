import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameResultsTest {

  private RacingCars racingCars;
  private RacingCarGameResults racingCarGameResults;
  private String[] playerNames = {"a", "bb", "ccccc"};

  @BeforeEach
  void setUp() {
    int roundAmount = 1;
    MoveStrategy alwaysMoveStrategy = () -> true;
    this.racingCars = new RacingCars(playerNames);
    this.racingCars.moveEachCars(alwaysMoveStrategy);
    this.racingCarGameResults = new RacingCarGameResults(roundAmount);
  }

  @Test
  @DisplayName("RacingCarGameResults에 결과를 더했을 때 잘 더해지는지 확인하기 위한 테스트")
  void addResult() {
    // given
    int round = 1;
    int expectedMovedDistance = 1;

    // when
    racingCarGameResults.addResult(round, racingCars);

    // then
    Map<Integer, List<RacingCarResult>> results = racingCarGameResults.getResults();
    List<RacingCarResult> roundResult = results.get(round);
    assertThat(roundResult.size()).isEqualTo(racingCars.getRacingCars().size());
    roundResult.forEach(result ->
            assertThat(result.getProgress()).isEqualTo(expectedMovedDistance)
    );
  }

  @Test
  @DisplayName("RacingCarGameResults에 특정 결과를 더했을 때 잘 더해지는지 확인하기 위한 테스트")
  void addResultWithDifferentDistance() {
    // given
    int round = 1;
    int expectedMovedDistance = 1;

    // when
    racingCarGameResults.addResult(round, racingCars);

    // then
    Map<Integer, List<RacingCarResult>> results = racingCarGameResults.getResults();
    List<RacingCarResult> roundResult = results.get(round);
    assertThat(roundResult.size()).isEqualTo(racingCars.getRacingCars().size());
    roundResult.forEach(result ->
            assertThat(result.getProgress()).isEqualTo(expectedMovedDistance)
    );
  }

}