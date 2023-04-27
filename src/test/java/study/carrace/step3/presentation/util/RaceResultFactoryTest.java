package study.carrace.step3.presentation.util;

import org.junit.jupiter.api.Test;
import study.carrace.step3.application.dto.RaceFinishedCar;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceResultFactoryTest {
    @Test
    void first_rankers() {
        // given
        List<RaceFinishedCar> raceFinishedCars = List.of(
                new RaceFinishedCar("foo", List.of(true, false, true)),
                new RaceFinishedCar("bar", List.of(true, true, false)),
                new RaceFinishedCar("baz", List.of(false, false, true))
        );

        // when
        List<String> firstRankers = RaceResultFactory.firstRankers(raceFinishedCars);

        // then
        assertThat(firstRankers).containsExactly("foo", "bar");
    }

    @Test
    void car_names_and_positions() {
        // given
        List<RaceFinishedCar> raceFinishedCars = List.of(
                new RaceFinishedCar("foo", List.of(true, false, true)),
                new RaceFinishedCar("bar", List.of(true, true, false))
        );
        int iteration = 2;

        // when
        String carNamesAndPositions = RaceResultFactory.carNamesAndPositionsAt(raceFinishedCars, iteration);

        // then
        String expectedCarNamesAndPositions = new StringBuilder()
                .append("foo:-\n")
                .append("bar:--\n")
                .toString();
        assertThat(carNamesAndPositions)
                .isEqualTo(expectedCarNamesAndPositions);
    }
}