package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    private RacingGame racingGame;
    public static final int CAR_COUNT = 5;
    public static final int TRY_COUNT = 4;
    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(CAR_COUNT, TRY_COUNT, new RandomProceedPolicy());
    }

    @Test
    void createRacingGameTest() {
        assertThat(racingGame).isNotNull();
    }

    @Test
    void createCarsTest() {
        Cars cars = racingGame.createCars();

        assertThat(cars).isNotNull();
        assertThat(cars.size()).isEqualTo(CAR_COUNT);
    }

}