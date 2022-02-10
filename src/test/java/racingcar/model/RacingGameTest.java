package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 시도횟수만큼_레이스를한다() {
        MoveStrategy moveStrategy = new RandomStrategy();
        RacingGame racingGame = new RacingGame(new Cars(Arrays.asList("pobi", "woni", "jun"),moveStrategy), 3);
        List<RaceResult> totalResult = racingGame.startRace();
        assertThat(totalResult.size()).isEqualTo(3);
    }
}