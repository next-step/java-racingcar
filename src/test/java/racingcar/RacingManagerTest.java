package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.RacingCarTestUtil.*;

public class RacingManagerTest {
    private final String MAX_PROGRESS = getMaxProgress();

    @Test
    void testStartRacing() {
        CarFactory carFactory = new CarFactory(NUM_OF_CARS);
        List<Car> carList = carFactory.buildCars();
        RacingManager racingManager = new RacingManager(NUM_OF_TRAIALS, carList);
        racingManager.startRacing();
        checkDistanceOfCars(carList);
    }

    private void checkDistanceOfCars(List<Car> carList) {
        carList.forEach( car -> {
                String progress = car.printProgress();
                assertThat(progress).isLessThanOrEqualTo(MAX_PROGRESS);
        });
    }
}
