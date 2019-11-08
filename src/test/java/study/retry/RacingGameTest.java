package study.retry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retry.domain.Car;
import retry.domain.Cars;
import retry.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(null);
    }


    @Test
    void racingCarsMoveTest() {
        List<Cars> cars = racingGame.racingGame();

    }
}
