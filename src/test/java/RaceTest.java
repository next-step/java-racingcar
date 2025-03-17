import static org.assertj.core.api.Assertions.assertThat;
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

        Race race = new Race(1, 3);
        assertThat(race.getCarPostions()).hasSize(1);
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

    @Test
    @DisplayName("경기 시작시 자동차의 위치는 0이다.")
    void carPositionsAtStartAreZero() {
        Race race = new Race(5, 3);
        for (Integer carPositions : race.getCarPostions()) {
            assertThat(carPositions).isZero();
        }
    }
}