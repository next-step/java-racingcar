package step4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import step4.racing.ExtendRacingGame;

public class ExtendRacingGameTest {

    @Test
    void 자동차_이름은_쉼표를_기준으로_구분한다() {
        ExtendRacingGame extendRacingGame = new ExtendRacingGame("pobi,crong,honux", 5);
        assertThat(extendRacingGame.carNames().length).isEqualTo(3);
        assertThat(extendRacingGame.carNames())
            .containsExactly("pobi", "crong", "honux");
    }

    @Test
    void 우승자는_한명_이상일수_있다() {
        ExtendRacingGame extendRacingGame = new ExtendRacingGame("pobi,crong,honux", 0);
        List<String> winners = extendRacingGame.winners();
        assertThat(winners.size()).isEqualTo(3);
    }
}
