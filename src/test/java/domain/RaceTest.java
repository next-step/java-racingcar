package domain;

import dto.RaceInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    Race race;
    static final int INIT_POSITION = 1;
    static final int NUMBER_OF_CARS_DEFAULT = 3;
    static final int NUMBER_OF_RACES_DEFAULT = 5;

    @BeforeEach
    void setUp() {
        race = new Race(new RaceInfo(new NumberOfCars(NUMBER_OF_CARS_DEFAULT), new NumberOfRaces(NUMBER_OF_RACES_DEFAULT)));
    }

    @Test
    void calculate() {
        RaceResult raceResult = race.calculate();
        for (GameResult gameResult : raceResult.getGames()) {
            for (Car car : gameResult.getCars()) {
                assertThat(car.getPosition()).isBetween(INIT_POSITION, INIT_POSITION + NUMBER_OF_RACES_DEFAULT);
            }
        }
    }
}
