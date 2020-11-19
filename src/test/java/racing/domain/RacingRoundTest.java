package racing.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingRoundTest {

    @Test
    void 경기_종료_후_가장_마지막_결과의_Cars를_반환() {
        // given
        int roundCount = 2;
        String[] names = {"dugi", "david", "wood"};
        RacingGame racingGame = new RacingGame(roundCount, names);

        // when
        RacingRound racingRound = racingGame.startRacing();

        // then
        Assertions.assertThat(racingRound.getLastRoundResult()).isSameAs(racingRound.getCars(racingRound.size() - 1));
    }
}