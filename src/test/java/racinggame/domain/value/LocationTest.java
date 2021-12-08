package racinggame.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    @Test
    @DisplayName("Forward 를 호출하면 value 가 1 증가해야 한다.")
    public void forward() {
        String carName = "car1";
        Location from = new Location(carName, 0);
        assertEquals(new Location(carName, 1), from.forward());
    }
}