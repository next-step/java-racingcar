package step2.race.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step2.car.domain.Car;
import step2.car.domain.engine.Engine;
import step2.car.domain.engine.RandomEngine;
import step2.race.domain.Race;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RaceServiceTest {

    private RaceService raceService;
    private Engine engine;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
        engine = new RandomEngine();
    }

    private static Stream<Arguments> testNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi"), 1),
                Arguments.of(Arrays.asList("pobi", "chanin"), 2),
                Arguments.of(Arrays.asList("pobi", "chanin", "someone"), 3)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2"}, delimiter = ':')
    void startRacing_전체_여러번_움직였을때_움직인만큼_경기기록_누적(Integer moveAmount, Integer answer) {
        //given
        List<String> names = Arrays.asList("pobi", "chanin");
        List<Car> cars = raceService.makeRacingCars(names, engine);
        Race race = new Race(cars);

        //when
        raceService.startRacing(race, moveAmount);

        //then
        assertThat(race.getRaceHistories()).hasSize(answer);
    }

    @ParameterizedTest
    @MethodSource("testNames")
    void makeRace_자동차만들기(List<String> names, Integer answer) {
        List<Car> cars = raceService.makeRacingCars(names, engine);

        assertThat(cars).hasSize(answer);
    }

}