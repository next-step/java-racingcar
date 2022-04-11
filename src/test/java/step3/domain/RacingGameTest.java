package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingGameTest {

    public static final int CAR_COUNT = 5;
    public static final int TRY_COUNT = 4;

    @Test
    void createRacingGameTest() {
        RacingGame racingGame = new RacingGame(CAR_COUNT, TRY_COUNT, new RandomProceedPolicy());

        assertThat(racingGame).isNotNull();
    }

}