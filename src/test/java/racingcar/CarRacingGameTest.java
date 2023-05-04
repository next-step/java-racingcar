package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarRacingGameTest {
    private CarRacingGame carRacingGame;
    private final MovingStrategy movingStrategy = new RandomMovingStrategy();

    @BeforeEach
    void init() {
        carRacingGame = new CarRacingGame(movingStrategy);
    }

    @Test
    @DisplayName("게임 플레이")
    void Test_play() {
        List<String> names = Arrays.asList("aaa", "bbb", "ccc");
        carRacingGame.play(new GameStartParameter(names, 7));
    }
}
