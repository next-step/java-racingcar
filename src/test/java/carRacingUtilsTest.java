import CarRacingGame.CarRacingGameUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class carRacingUtilsTest {

    private CarRacingGameUtils carRacingGameUtils;

    @BeforeEach
    public void setUp() {
        carRacingGameUtils = new CarRacingGameUtils();
    }

    @Test
    @DisplayName("Set the numbers of the cars and check proper numbers of items")
    public void testInitialCarSettings() {
        carRacingGameUtils.initialCarSettings(3);
        Map<String, String> cars = carRacingGameUtils.initialCarSettings(3);  // 자동차 상태 확인

        assertEquals(3, cars.size());

    }

}
