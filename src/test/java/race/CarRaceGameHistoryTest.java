package race;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRaceGameHistoryTest {
    @Test
    void record_게임_진행상황을_기록한다() {
        int round = 2;
        int step = 4;
        String name = "dex";

        CarRaceGameHistory history = CarRaceGameHistory.record(round, step, name);

        assertThat(history).isEqualTo(CarRaceGameHistory.record(round, step, name));
    }

    @Test
    void selectWinningHistories_우승자를_가려낸다() {
        int round = 3;
        int maxStep = 5;

        CarRaceGameHistory winnigHistory1 = CarRaceGameHistory.record(round, maxStep, "hani");
        CarRaceGameHistory winnigHistory2 = CarRaceGameHistory.record(round, maxStep, "dani");
        CarRaceGameHistory losingHistory = CarRaceGameHistory.record(round, 0, "minji");

        List<CarRaceGameHistory> winningHistories =
                CarRaceGameHistory.selectWinningHistories(Arrays.asList(winnigHistory1, winnigHistory2, losingHistory));

        assertThat(winningHistories).isEqualTo(Arrays.asList(winnigHistory1, winnigHistory2));

    }

    @Test
    void selectWinningHistories_같은_라운드의_게임기록이_아닌_경우_예외를_발생시킨다() {
        int round = 3;

        CarRaceGameHistory roundHistory1 = CarRaceGameHistory.record(round, 1, "hani");
        CarRaceGameHistory roundHistory2 = CarRaceGameHistory.record(round, 1, "dani");
        CarRaceGameHistory otherRoundHistory = CarRaceGameHistory.record(1, 1, "minji");

        assertThatThrownBy(() -> CarRaceGameHistory.selectWinningHistories(Arrays.asList(roundHistory1, roundHistory2
                , otherRoundHistory))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("같은 라운드의 게임 "
                + "기록이 아닙니다.");
    }
}
