package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.function.Supplier;

class RacingGameTest {
    private RacingGame racingGame;
    private static final int TEST_CARS = 3;
    private static final int TEST_ROUNDS = 5;



    @Test
    void testCarCreation() {
        assertNotNull(racingGame);
    }

    @Test
    void testRaceProgression() {
        racingGame.start();
        List<Car> cars = racingGame.getCars();

        assertEquals(TEST_CARS, cars.size());
        for (Car car : cars) {
            assertNotNull(car.getPosition());
        }
    }

}