package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceGameHistoryTest {
    @Test
    void record_게임_진행상황을_기록한다() {
        int round = 2;
        int step = 4;

        CarRaceGameHistory history = CarRaceGameHistory.record(round, step);
        assertThat(history.getRound()).isEqualTo(round);
    }
}
