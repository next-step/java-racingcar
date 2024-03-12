package racingcar.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    private final Policy mockPolicy = new RandomPolicy();
    private final int numberOfCars = 5;
    private final int numberOfAttempts = 3;
    private Race race;

    @BeforeEach
    void setUp() {
        //given
        race = new Race(mockPolicy, numberOfCars, numberOfAttempts);
    }

    @DisplayName("n개의 자동차 객체생성")
    @Test
    void checkNumberOfCarsReady() {
        //when
        List<Car> cars = race.initializeCars(numberOfCars);

        //then
        assertThat(cars).isNotNull();
        assertThat(numberOfCars).isEqualTo(cars.size());
    }

    @DisplayName("n개의 차량, n개의 경주결과")
    @Test
    void checkNumberOfResult() {
        //when
        List<RoundResultMap> results = race.start();

        //then
        assertThat(results).isNotNull();
        assertThat(numberOfAttempts).isEqualTo(results.size());
    }
}
