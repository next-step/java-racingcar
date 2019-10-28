package step2.race.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.car.domain.Car;
import step2.car.domain.engine.Engine;
import step2.car.domain.engine.RandomEngine;
import step2.race.domain.Race;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceServiceTest {

    private RaceService raceService;
    private Engine engine;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
        engine = new RandomEngine();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2"}, delimiter = ':')
    void startRacing_전체_여러번_움직였을때_움직인만큼_경기기록_누적(Integer moveAmount, Integer answer) {
        //given
        List<Car> cars = raceService.makeRacingCars(1, engine);
        Race race = new Race(cars);

        //when
        raceService.startRacing(race, moveAmount);

        //then
        assertThat(race.getRaceHistories()).hasSize(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void makeRace_자동차만들기(Integer carAmount, Integer answer) {
        List<Car> cars = raceService.makeRacingCars(carAmount, engine);

        assertThat(cars).hasSize(answer);
    }

}