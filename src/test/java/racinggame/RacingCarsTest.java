package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.fixture.CarFixture.*;

class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<Car> cars = new ArrayList<>();
        cars.add(CAR1);
        cars.add(CAR2);
        cars.add(CAR3);
        cars.add(CAR4);
        racingCars = new RacingCars(cars);
    }

    @DisplayName("자동차 전진 결과 반환")
    @ParameterizedTest
    @CsvSource(value = {
            "4 | 4",
            "6 | 6",
            "5 | 5"
    }, delimiter = '|')
    void move(int attempts, int expectSize) {
        RacingCars resultCars = racingCars.move(attempts);

        assertThat(resultCars.getRacingResult()
                .results()
                .size())
                .isEqualTo(expectSize);
    }
}