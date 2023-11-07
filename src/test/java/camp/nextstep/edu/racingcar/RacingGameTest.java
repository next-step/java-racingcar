package camp.nextstep.edu.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.racingcar.domain.RacingGame;
import camp.nextstep.edu.racingcar.domain.result.RacingGameResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("전략 객체를 실행한 값이 true라면 자동차들이 여러 번 전진한다")
    void mustDrive() {
        // given
        DriveStrategy driveStrategy = () -> true;
        RacingGame racingGame = new RacingGame(driveStrategy, 2, 2);

        // when
        RacingGameResult gameResult = racingGame.play();

        // then
        assertThat(gameResult.toString()).isEqualTo("-\n-\n\n--\n--\n\n");
    }

    @Test
    @DisplayName("전략 객체를 실행한 값이 true라면 자동차들이 여러 번 전진하지 않는다")
    void mustNotDrive() {
        // given
        DriveStrategy driveStrategy = () -> false;
        RacingGame racingGame = new RacingGame(driveStrategy, 2, 2);

        // when
        RacingGameResult gameResult = racingGame.play();

        // then
        assertThat(gameResult.toString()).isEqualTo("\n\n\n\n\n\n");
    }
}
