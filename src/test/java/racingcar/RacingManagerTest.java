package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingManagerTest {

    @Test
    @DisplayName("레이싱이 진행됨에 따라 레이싱 결과가 저장된다.")
    void 레이싱이_진행됨에_따라_레이싱_결과가_저장된다() {
        RacingManager racingManager = new RacingManager(List.of("ipt", "chan", "pobi"), 4);

        RacingResult racingResult = racingManager.playRacing();

        List<Cars> racingHistory = racingResult.getRacingHistory();
        List<String> winnerNames = racingResult.getWinnerNames();

        assertThat(racingHistory.size()).isEqualTo(4);
        assertThat(winnerNames).containsAll(winnerNames(racingHistory));
    }

    private List<String> winnerNames(List<Cars> racingHistory) {
        return getLastHistory(racingHistory)
                .findWinnerNames();
    }

    private Cars getLastHistory(List<Cars> racingHistory) {
        int size = racingHistory.size();
        return racingHistory.get(size - 1);
    }

}