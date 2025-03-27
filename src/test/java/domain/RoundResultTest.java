package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultTest {

    @DisplayName("우승자 찾기 테스트")
    @Test
    void saveProgress() {
        String car1Name = "car1";
        String car2Name = "car2";

        RacingCar car1 = new RacingCar(car1Name);
        RacingCar car2 = new RacingCar(car2Name);

        RacingCars cars = new RacingCars(List.of(car1.move(), car2));

        RoundResult roundResult = new RoundResult(cars);
        assertThat(roundResult.findWinners()).containsOnly(car1Name);
    }
}