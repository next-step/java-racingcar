package racingcar.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 5"}, delimiter = ',')
    void initialize(int countOfCars, int countOfMovesAttemps) {
        racing.initialize(countOfCars, countOfMovesAttemps);
        Map<Car, Integer> currentSituation = racing.getCurrentSituation();

        // 등록된 자동차 이름 확인
        assertThat(currentSituation).containsKeys(Car.of(CarName.get(0)), Car.of(CarName.get(1)), Car.of(CarName.get(2)));
        // 등록된 자동차 이동 거리 확인
        assertThat(currentSituation).containsValues(0, 0, 0);
    }

}
