package racinggame.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    @Test
    @DisplayName("Forward 를 호출하면 value 가 1 증가해야 한다.")
    public void forward() {
        Location from = new Location(0);
        assertEquals(new Location(1), from.forward());
    }
}