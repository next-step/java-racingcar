package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    public static final int CAR_COUNT = 5;
    public static final int TRY_COUNT = 4;

    @Test
    void createRacingGameTest() {
        RacingGame racingGame = new RacingGame(List.of("car1"), new RandomProceedPolicy());

        assertThat(racingGame).isNotNull();
    }

}