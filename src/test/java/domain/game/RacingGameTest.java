package domain.game;

import domain.record.Records;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 주행_거리는_차의_개수와_시도_횟수를_곱한_만큼_기록된다() {

        int trial = 5;
        int totalRecord = 10;

        // given
        RacingGame game = new RacingGame("alex", "jake");

        // when
        Records records = game.start(trial);

        // then
        assertThat(records.gameRecord()).hasSize(totalRecord);
    }
}
