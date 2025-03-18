package car_racing.domain.model;

import car_racing.domain.strategy.CarMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultsTest {
    @Test
    @DisplayName("더 많이 움직인 차가 우승한다")
    void getWinners() {
        String carName1 = "car1";
        String carName2 = "car2";

        Cars cars = new Cars(List.of(carName1, carName2), new TestCarMovingStrategy());
        cars.moveAll();

        RaceResultOfRound raceResult = new RaceResultOfRound(cars);
        RaceResults raceResults = new RaceResults();
        raceResults.addRaceResult(raceResult);

        assertThat(raceResults.getWinnersName()).isEqualTo(List.of(carName1));
    }

    @Test
    @DisplayName("움직인 거리가 제일 큰 차가 여러 대인 경우 우승자가 여러 명이다")
    void multiWinners() {
        String carName1 = "car1";
        String carName2 = "car2";
        String carName3 = "car3";

        Cars cars = new Cars(List.of(carName1, carName2, carName3), new TestCarMovingStrategy());
        cars.moveAll();

        RaceResultOfRound raceResult = new RaceResultOfRound(cars);
        RaceResults raceResults = new RaceResults();
        raceResults.addRaceResult(raceResult);

        assertThat(raceResults.getWinnersName())
                .containsExactlyInAnyOrder(carName1, carName3);
    }

    static class TestCarMovingStrategy implements CarMovingStrategy {
        int i = 0;

        @Override
        public boolean movable() {
            return (i++ % 2) == 0;
        }
    }
}
