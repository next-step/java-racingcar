package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    @DisplayName("currentTryCount가 totalTryCount보다 작으면 경주를 마치지 않는다.")
    public void aaa() {
        Race race = new Race(3, 2);
        race.continueRace();
        assertThat(race.isNotFinished()).isTrue();
    }

    @Test
    @DisplayName("currentTryCount가 totalTryCount와 같으면 경주를 마친다.")
    public void bbb() {
        Race race = new Race(3, 2);
        race.continueRace();
        race.continueRace();
        assertThat(race.isNotFinished()).isFalse();
    }
}
