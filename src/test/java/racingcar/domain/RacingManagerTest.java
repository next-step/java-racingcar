package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class RacingManagerTest {

    @Test
    @DisplayName("레이싱이 진행됨에 따라 레이싱 결과가 저장된다.")
    void 레이싱이_진행됨에_따라_레이싱_결과가_저장된다() {
        RacingManager racingManager = new RacingManager("ipt,chan,pobi", 4);

        RacingResult racingResult = racingManager.playRacing();

        List<Cars> racingHistory = racingResult.getRacingHistory();
        List<String> winnerNames = racingResult.getWinnerNames();

        assertThat(racingHistory.size()).isEqualTo(5);
        assertThat(winnerNames).containsAll(winnerNames(racingHistory));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있는 경우 예외를 던집니다.")
    void 중복된_자동차_이름이_있는_경우_예외를_던집니다() {
        assertThatCode(() -> new RacingManager("ipt,ipt,pobi", 4))
                .isInstanceOf(IllegalStateException.class);
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