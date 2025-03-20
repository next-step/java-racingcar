import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    @DisplayName("자동차 개수는 양수여야 한다.")
    void negativeOrZeroCarCountInputReturnsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(new GameSettings(-1, 3));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(new GameSettings(0, 3));
        });

        Race race = new Race(new GameSettings(1, 3));
        assertThat(race.getCarStatuses()).hasSize(1);
    }

    @Test
    @DisplayName("경주 횟수는 양수여야 한다.")
    void negativeOrZeroRaceCountInputReturnsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(new GameSettings(5, -1));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(new GameSettings(5, 0));
        });

        assertDoesNotThrow(() -> {
            new Race(new GameSettings(5, 1));
        });
    }

    @Test
    @DisplayName("경기 시작시 자동차의 위치는 0이다.")
    void carPositionsAtStartAreZero() {
        Race race = new Race(new GameSettings(5, 3));
        for (CarStatus carStatus : race.getCarStatuses()) {
            assertThat(carStatus.getPosition()).isZero();
        }
    }

    @Test
    @DisplayName("한 라운드가 진행되면 자동차의 위치는 기존 위치이거나, 기존 위치 + 1이다.")
    void carPositionsAfterOneRoundAreEitherSameOrIncremented() {
        Race race = new Race(new GameSettings(5, 3));
        List<CarStatus> initialStatuses = race.getCarStatuses();

        race.runRound();
        List<CarStatus> finalStatuses = race.getCarStatuses();

        for (int i = 0; i < initialStatuses.size(); i++) {
            assertThat(finalStatuses.get(i).getPosition()).isIn(initialStatuses.get(i).getPosition(), initialStatuses.get(i).getPosition() + 1);
        }
    }

    @Test
    @DisplayName("전체 라운드를 넘어가면 에러가 발생한다.")
    void exceedingTotalRoundsThrowsError() {
        Race race = new Race(new GameSettings(5, 3));
        for (int i = 0; i < 3; i++) {
            race.runRound();
        }
        assertThrows(IllegalStateException.class, race::runRound);
    }
}
