package camp.nextstep.edu.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.racingcar.domain.RacingGame;
import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.result.RacingGameResult;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("전략 객체를 실행한 값이 true라면 자동차들이 여러 번 전진한다")
    void mustDrive() {
        // given
        DriveStrategy driveStrategy = () -> true;
        RacingGame racingGame = new RacingGame(driveStrategy, new String[] { "a", "b" }, 2);

        // when
        RacingGameResult gameResult = racingGame.play();

        // then
        List<RoundResult> roundResults = gameResult.roundResults();
        assertThat(roundResults.size()).isEqualTo(2);

        List<DriveResult> driveResultsRound1 = roundResults.get(0).driveResults();
        assertThat(driveResultsRound1.size()).isEqualTo(2);
        assertThat(driveResultsRound1.get(0).drivenDistance()).isEqualTo(1);
        assertThat(driveResultsRound1.get(1).drivenDistance()).isEqualTo(1);

        List<DriveResult> driveResultsRound2 = roundResults.get(1).driveResults();
        assertThat(driveResultsRound2.size()).isEqualTo(2);
        assertThat(driveResultsRound2.get(0).drivenDistance()).isEqualTo(2);
        assertThat(driveResultsRound2.get(1).drivenDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("전략 객체를 실행한 값이 false라면 자동차들이 여러 번 전진하지 않는다")
    void mustNotDrive() {
        // given
        DriveStrategy driveStrategy = () -> false;
        RacingGame racingGame = new RacingGame(driveStrategy, new String[] { "a", "b" }, 2);

        // when
        RacingGameResult gameResult = racingGame.play();

        // then
        List<RoundResult> roundResults = gameResult.roundResults();
        assertThat(roundResults.size()).isEqualTo(2);

        List<DriveResult> driveResultsRound1 = roundResults.get(0).driveResults();
        assertThat(driveResultsRound1.size()).isEqualTo(2);
        assertThat(driveResultsRound1.get(0).drivenDistance()).isEqualTo(0);
        assertThat(driveResultsRound1.get(1).drivenDistance()).isEqualTo(0);

        List<DriveResult> driveResultsRound2 = roundResults.get(1).driveResults();
        assertThat(driveResultsRound2.size()).isEqualTo(2);
        assertThat(driveResultsRound2.get(0).drivenDistance()).isEqualTo(0);
        assertThat(driveResultsRound2.get(1).drivenDistance()).isEqualTo(0);
    }
}
