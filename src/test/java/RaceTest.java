import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    @DisplayName("자동차 개수는 양수여야 한다.")
    void negativeOrZeroCarCountInputReturnsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(-1, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(0, 3);
        });
    }

    @Test
    @DisplayName("경주 횟수는 양수여야 한다.")
    void negativeOrZeroRaceCountInputReturnsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(5, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(5, 0);
        });
    }
}