package RacingGame;

import RacingGame.model.CarsHistory;
import RacingGame.model.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class CarsHistoryTest {
    @Test
    @DisplayName("차량들의 기록 값들을 반환")
    void addStageTest() {
        CarsHistory carsHistory = new CarsHistory(List.of("Car1", "Car2"), 3);
        carsHistory.addStage(Map.of("Car1", 1, "Car2", 2));

        Assertions.assertThat(carsHistory.getCarsHistory().get("Car1").get(0).getPosition()).isEqualTo(1);
        Assertions.assertThat(carsHistory.getCarsHistory().get("Car2").get(0).getPosition()).isEqualTo(2);

    }

    @Test
    @DisplayName("차량들의 총 기록할 스테이지 수를 반환")
    void testStageCount() {
        CarsHistory carsHistory = new CarsHistory(List.of("Car1", "Car2"), 5);
        Assertions.assertThat(carsHistory.StageCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("마지막 결과를 반환")
    void testGetFinalStage() {
        CarsHistory carsHistory = new CarsHistory(List.of("Car1", "Car2"), 3);
        carsHistory.addStage(Map.of("Car1", 1, "Car2", 2));
        carsHistory.addStage(Map.of("Car1", 3, "Car2", 4));
        carsHistory.addStage(Map.of("Car1", 5, "Car2", 6));

        Assertions.assertThat(carsHistory.getFinalStage())
                .isEqualTo(Map.of("Car1", new Position(5), "Car2", new Position(6)));
    }
}
