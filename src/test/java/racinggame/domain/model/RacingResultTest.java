package racinggame.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.vo.CarSateInRace;

class RacingResultTest {

  private List<MovingResult> movingResults = Arrays.asList(
      new MovingResult(Arrays.asList(new CarSateInRace("a", 1),
          new CarSateInRace("b", 1),
          new CarSateInRace("c", 2))),
      new MovingResult(Arrays.asList(new CarSateInRace("a", 2),
          new CarSateInRace("b", 1),
          new CarSateInRace("c", 2))),
      new MovingResult(Arrays.asList(new CarSateInRace("a", 3),
          new CarSateInRace("b", 2),
          new CarSateInRace("c", 2))));

  @Test
  @DisplayName("경주 결과 중 장 앞서있는 carName을 잘 반환하는가?")
  void getWinnerCarNamesTest() {
    RacingResult racingResult = new RacingResult(movingResults);
    assertThat(racingResult.getWinnerCarNames()).isEqualTo("a");
  }

}