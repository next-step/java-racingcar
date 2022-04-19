package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.RacingCarMainApp.proceedPolicy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    public static final int TRY_COUNT = 4;

    @Test
    void createRacingGameTest() {
        RacingGame racingGame = new RacingGame(List.of("car1"), proceedPolicy);

        assertThat(racingGame).isNotNull();
    }

}