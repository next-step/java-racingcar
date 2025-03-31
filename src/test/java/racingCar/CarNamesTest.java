package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.CarNames;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CarNamesTest {

    @Test
    void carNamesAreCreatedCorrectly() {
        CarNames carNames = new CarNames("1,2,3");

        List<String> names = carNames.getNames();
        assertEquals(3, names.size());
        assertTrue(names.contains("1"));
        assertTrue(names.contains("2"));
        assertTrue(names.contains("3"));
    }

    @Test
    void exceptionIsThrownIfCarNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new CarNames(" , , "));
    }

    @Test
    void exceptionIsThrownIfCarNameIsTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new CarNames("123456,123456"));
    }

    @Test
    void atLeastOneCarNameIsRequired() {
        assertThrows(IllegalArgumentException.class, () -> new CarNames(""));
    }

    @Test
    void leadingAndTrailingSpacesAreTrimmedFromCarNames() {
        CarNames carNames = new CarNames("  1 ,  2 ");

        List<String> names = carNames.getNames();
        assertEquals(2, names.size());
        assertTrue(names.contains("1"));
        assertTrue(names.contains("2"));
    }
}
