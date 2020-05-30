package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.stub.MoveForwardingRacingGameStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("Racing game의 결과가 잘 나오는지 확인 (3대씩 5대라면 총 15회의 결과기록이 있어야함)")
    @Test
    public void raceStartTest() {
        // given
        int carNumbers = 3;
        int raceTimes = 5;

        // when
        RacingGame racingGame = new RacingGame(carNumbers, raceTimes);
        List<Integer> result = racingGame.raceStart();

        // then
        assertThat(result.size()).isEqualTo(carNumbers * raceTimes);
    }

    @DisplayName("Racing game에 참가한 모든 자동차가 움직였다 가정했을 때 결과기록이 모두 0보다 커야 함")
    @Test
    public void raceStartMoveForwardTest() {
        // given
        int carNumbers = 3;
        int raceTimes = 5;

        // when
        RacingGame racingGame = new MoveForwardingRacingGameStub(carNumbers, raceTimes);
        List<Integer> result = racingGame.raceStart();

        // then
        assertThat(result.size()).isEqualTo(carNumbers * raceTimes);
        assertThat(result.stream().filter(r -> r > 0).count()).isEqualTo(carNumbers * raceTimes);
    }
}
