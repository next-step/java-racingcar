package RacingGame;

import RacingGame.model.RacingResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class RacingResultTest {
    @Test
    @DisplayName("마지막 스테이지 Car1 위치 1, Car2 위치 3로 Car2 우승")
    void testWinners() {
        RacingResult racingResult = new RacingResult(List.of("Car1", "Car2"), 3);
        racingResult.addStage(Map.of("Car1", 1, "Car2", 1));
        racingResult.addStage(Map.of("Car1", 1, "Car2", 2));
        racingResult.addStage(Map.of("Car1", 1, "Car2", 3));

        Assertions.assertThat(racingResult.winners()).isEqualTo(List.of("Car2"));
    }
}
