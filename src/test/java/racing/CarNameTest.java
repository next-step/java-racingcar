package racing;

import org.junit.jupiter.api.Test;
import racing.entity.CarName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @Test
    void carNameIsSetCorrectly() {
        CarName carName = new CarName("Car");
        assertEquals("Car", carName.getValue());
    }

    @Test
    void carNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(null));
    }

    @Test
    void carNameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(""));
    }
}
