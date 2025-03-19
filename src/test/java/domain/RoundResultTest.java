package domain;

import movingStrategy.AlwaysMove;
import movingStrategy.NeverMove;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RoundResultTest {

    @DisplayName("1회 진행 시 결과를 저장")
    @Test
    void saveProgress() {
        RacingCar car1 = new RacingCar(new AlwaysMove());
        RacingCar car2 = new RacingCar(new NeverMove());
        List<RacingCar> cars = List.of(car1, car2);

        car1.move();
        car2.move();

        RoundResult roundResult = new RoundResult(cars);
        List<Integer> raceProgress = roundResult.whereAreCars();
        Assertions.assertEquals(List.of(1, 0), raceProgress);
    }

}