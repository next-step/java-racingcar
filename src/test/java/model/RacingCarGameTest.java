package model;

import controller.RacingGameController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    @DisplayName("라운드 수만큼 자동차가 항상 움직이는지 테스트")
    public void testRacingRounds() {
        int numOfCars = 3;
        int numOfRounds = 5;
        String carNames = "가,나,다";
        RacingGameController racingGame = new RacingGameController(numOfCars, carNames);

        List<Car> cars = racingGame.startRace(() -> true);

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(numOfRounds);
        }
    }

    @Test
    void testCarNameLength() {
        String careName = "가나다라마바";

    }
}
