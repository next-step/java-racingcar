package domain;

import movingStrategy.AlwaysMove;
import movingStrategy.NeverMove;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultTest {

    @DisplayName("1회 진행 시 결과를 저장")
    @Test
    void saveProgress() {
        String car1Name = "car1";
        String car2Name = "car2";

        RacingCar car1 = new RacingCar(car1Name, new AlwaysMove());
        RacingCar car2 = new RacingCar(car2Name, new NeverMove());

        List<RacingCar> cars = List.of(car1, car2);

        car1.move();
        car2.move();

        List<String> expectedNames = List.of(car1Name, car2Name);
        List<Integer> expectedPositions = List.of(1, 0);

        RoundResult roundResult = new RoundResult(cars);
        List<RacingCarCurrentStatus> raceProgress = roundResult.getRaceProgress();
        assertThat(raceProgress).allMatch(status ->
                expectedNames.contains(status.name()) &&
                        expectedPositions.contains(status.position()));
    }
}