package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RaceGameTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 사용자_입력값만큼의_경주에_참가할_자동차를_생성할_수_있다(final int competitorCount) {
        //given
        final int forwardAttempts = 2;
        RaceGame raceGame = new RaceGame(competitorCount, forwardAttempts);
        //then
        assertThat(raceGame).isNotNull();
        assertThat(raceGame.getCars().size()).isEqualTo(competitorCount);
    }
}
