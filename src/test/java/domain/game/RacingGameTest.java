package domain.game;

import domain.record.Records;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private final int TRIAL = 5;
    private final int TOTAL_RECORD = 10;

    @Test
    void 주행_거리는_차의_개수와_시도_횟수를_곱한_만큼_기록된다() {

        // given
        String[] nameOfCars = {"alex", "jake"};
        RacingGame game = new RacingGame(nameOfCars);

        // when
        Records records = game.start(TRIAL);

        // then
        assertThat(records.gameRecord()).hasSize(TOTAL_RECORD);
    }
}
