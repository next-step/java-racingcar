package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.RacingCarTestUtil.NAMES_OF_CARS;
import static racingcar.RacingCarTestUtil.NUMBER_OF_CARS;

public class RacingManagerTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        CarFactory carFactory = new CarFactory(NAMES_OF_CARS);
        cars = carFactory.buildCars();
    }

    @Test
    void testRacingManager() {
        RacingManager racingManager = new RacingManager(cars);
        List<CarState> progressOfCars = racingManager.progressRound();
        assertThat(progressOfCars.size()).isEqualTo(NUMBER_OF_CARS);
    }
}
