package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 자동차경주_시작_시_총_라운드_체크() {
        // given
        int roundCount = 2;
        String[] names = {"dugi", "david", "wood"};
        RacingGame racingGame = new RacingGame(roundCount, names);

        // when
        RacingRound racingRound = racingGame.startRacing();

        // then
        Assertions.assertThat(racingRound.size()).isEqualTo(2);
    }

    @Test
    void 자동차경주_시_RacingRound객체_반환() {
        // given
        int roundCount = 2;
        String[] names = {"dugi", "david", "wood"};
        RacingGame racingGame = new RacingGame(roundCount, names);

        // when
        RacingRound racingRound = racingGame.startRacing();

        // then
        Assertions.assertThat(racingRound).isInstanceOf(RacingRound.class);
    }
}