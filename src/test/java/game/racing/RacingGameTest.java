package game.racing;

import game.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RacingGameTest {

    @DisplayName("레이싱 게임 시작, 결과 반환")
    @Test
    void name() {

        // given
        int expected = 5;
        RacingGameSettings settings = new RacingGameSettings();
        settings.setNumberOfCar(3);
        settings.setNumberOfTimes(expected);
        Game game = new RacingGame(settings);

        // when
        game.run();

        // then
        assertThat(game.getResult().getExecutionResults().size()).isEqualTo(expected);

    }


}
