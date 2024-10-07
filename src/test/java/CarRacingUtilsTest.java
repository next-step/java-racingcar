
import carRacingGame.CarRacingGameUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CarRacingUtilsTest {

    private CarRacingGameUtils carRacingGameUtils;

    @BeforeEach
    public void setUp() {
        carRacingGameUtils = new CarRacingGameUtils();
    }

    @Test
    @DisplayName("Test if car names are properly saved")
    public void testSetupCars() {
        String[] carNames = {"Car1", "Car2", "Car3"};

        Map<String, String> cars = carRacingGameUtils.setupCars(carNames);

        assertEquals(3, cars.size());
        assertTrue(cars.containsKey("Car1"));
        assertTrue(cars.containsKey("Car2"));
        assertTrue(cars.containsKey("Car3"));
    }

    @Test
    public void testMakeDistanceOfCars() {

        String initialPosition = "";
        String newPosition = carRacingGameUtils.moveForward(initialPosition);
        assertTrue(newPosition.equals("") || newPosition.equals("-"));
    }

    @Test
    public void testMoveCars() {

        String[] carNames = {"Car1", "Car2"};
        carRacingGameUtils.setupCars(carNames);
        carRacingGameUtils.moveCars();
        carRacingGameUtils.cars.forEach((carName, position) -> {
            assertTrue(position.equals("") || position.equals("-"));
        });
    }

    @Test
    @DisplayName("test if winners found properly")
    public void testRacingResult() {

        String[] carNames = {"Car1", "Car2"};
        carRacingGameUtils.setupCars(carNames);
        carRacingGameUtils.moveCars();
        carRacingGameUtils.racingResult();

        assertFalse(carRacingGameUtils.finalWinners.isEmpty());
    }
}
