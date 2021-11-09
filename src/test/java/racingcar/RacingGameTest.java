package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.collection.RaceResult;
import racingcar.model.RacingGameRequest;
import racingcar.strategy.TestMoveStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RacingGameTest {

    @Test
    @DisplayName("playRace 메소드는 자동차들을 경주시키고 RaceResult를 반환한다")
    public void 테스트_RacingGame_playRace() {
        final List<String> carNames = Arrays.asList("pobi","crong","honux");
        final int countOfTry = 3;

        RacingGame racingGame = new RacingGame(new RacingGameRequest(carNames, countOfTry),
                new TestMoveStrategy());
        RaceResult raceResult = racingGame.playRace();

        assertThat(raceResult.getLabResults().size()).isEqualTo(countOfTry);
        List<String> winnerNames = raceResult.getWinnerNames();
        assertThat(winnerNames.size()).isGreaterThan(0);

    }
}