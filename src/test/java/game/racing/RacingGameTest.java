package game.racing;

import game.Game;
import game.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RacingGameTest {

    @DisplayName("레이싱 게임 시작, 결과 반환")
    @Test
    void run() {

        // given
        ByteArrayInputStream in = new ByteArrayInputStream("name1,2,3,4,5\n5".getBytes());
        RacingGameSettings settings = new RacingGameSettings();
        InputView inputView = new InputView(in, settings);
        inputView.render();

        Game game = new RacingGame(settings);

        // when
        game.run();

        // then
        assertThat(game.getResult().getExecutionResults().size()).isEqualTo(5);

    }


}
