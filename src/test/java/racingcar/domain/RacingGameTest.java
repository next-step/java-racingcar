package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.util.FixedRandomGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void 시도_횟수만큼_라운드가_진행되면_경주가_종료된다() {
        RacingGame racingGame = new RacingGame(Cars.fromNames(List.of("pobi")), 3);
        RandomMoveStrategy strategy = new RandomMoveStrategy(new FixedRandomGenerator(0));

        for (int round = 0; round < 3; round++) {
            assertThat(racingGame.isFinished()).isFalse();
            racingGame.playRound(strategy);
        }

        assertThat(racingGame.isFinished()).isTrue();
    }
}