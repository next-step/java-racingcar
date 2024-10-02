import CarRacingGame.CarRacingGameUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarRacingUtilsTest {

    private CarRacingGameUtils carRacingGameUtils;

    @BeforeEach
    public void setUp() {
        carRacingGameUtils = new CarRacingGameUtils();
    }

    @Test
    @DisplayName("Set the numbers of the cars and check proper numbers of items")
    public void testInitialCarSettings() {
        carRacingGameUtils.initialCarSettings(3);
        Map<String, String> cars = carRacingGameUtils.initialCarSettings(3);
        assertEquals(3, cars.size());

    }

    @Test
    @DisplayName("Set the numbers of the cars and check cars move properly")
    public void testMoveCars() {
        int numberOfCars = 2;
        carRacingGameUtils.initialCarSettings(numberOfCars);
        carRacingGameUtils.moveCars();
        carRacingGameUtils.cars.forEach((car, position) -> {
            assertTrue(position.equals("-") || position.equals("--"));
        });
    }
}
