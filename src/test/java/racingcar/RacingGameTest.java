package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("RacingGame 실행시 입력받은 자동차 대수, 시도할 회수로 실행한 결과가 반환된다.")
    void runRacingGame() {

        //given
        int carNumber = 2;
        int runNumber = 3;

        //when
        RacingGame racingGame = new RacingGame(carNumber, runNumber);
        List<RacingCycle> cycles = racingGame.getCycles();

        //then
        assertThat(cycles).hasSize(runNumber);
        assertThat(cycles.get(0).get()).hasSize(carNumber);
    }
}
