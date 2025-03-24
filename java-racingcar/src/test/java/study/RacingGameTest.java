package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class RacingGameTest {
    private RacingGame racingGame;
    private static final int TEST_CARS = 3;
    private static final int TEST_ROUNDS = 5;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(TEST_CARS, TEST_ROUNDS);
    }

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

    @Test
    void testCarMovesOrStays() {
        Car car = new Car();
        String initialPosition = car.getPosition();
        car.move();
        String newPosition = car.getPosition();
        assertTrue(newPosition.equals(initialPosition) || newPosition.length() > initialPosition.length());
    }
}
