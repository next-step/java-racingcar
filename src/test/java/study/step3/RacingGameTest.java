package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Movable;
import step3.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private static final String CAR_NAMES = "pobi,crong,honux";
    private static final int TIME = 3;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(CAR_NAMES, TIME);
    }
}