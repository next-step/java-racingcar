package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.MovingResult;
import racinggame.model.RacingResult;
import racinggame.vo.CarSateInRace;
import racinggame.vo.RacingInfo;

class CarRacingTest {

  private static final RacingInfo MOCK_RACING_INFO = new RacingInfo(3, 2);
  private CarRacing MOCK_RACING = new CarRacing(MOCK_RACING_INFO);

  @Test
  @DisplayName("레이싱 결과 리스트사이즈가 RaceInfo의 roundCount와 같은가?")
  void startRacing() {
    RacingResult assertRacingResult = new RacingResult(List.of(
        new MovingResult(List.of(
            new CarSateInRace(0, 1),
            new CarSateInRace(1, 2),
            new CarSateInRace(2, 3)
        ))
        , new MovingResult(List.of(
            new CarSateInRace(0, 1),
            new CarSateInRace(1, 2),
            new CarSateInRace(2, 3)
        ))
    ));

    assertThat(MOCK_RACING.startRacing()).isEqualTo(assertRacingResult);
  }
}