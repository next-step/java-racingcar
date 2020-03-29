package study.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private final List<String> EXAMPLE_CARS =
            Arrays.asList("luvram", "boram", "rambo");
    private MovableDistance movableDistance;
    private Cars cars;

    @BeforeEach
    void setUp() {
        movableDistance = () -> 1;
        cars = new Cars(EXAMPLE_CARS);
    }

    @DisplayName("입력한 수행 횟수만큼 게임을 진행할 수 있다.")
    @Test
    void moveByTheNumberOfTimes() {
        int time = 3;
        RacingGame racingGame =
                new RacingGame(cars, movableDistance);

        RacingGameResult racingGameResult = racingGame.play(time);
        assertThat(racingGameResult.getGameEvent().size()).isEqualTo(time);
    }

    @DisplayName("모든 차가 수행 횟수만큼 전진할 수 있다.")
    @Test
    void success() {
        int time = 3;
        RacingGame racingGame =
                new RacingGame(cars, movableDistance);

        RacingGameResult racingGameResult = racingGame.play(time);

        assertThat(racingGameResult.getWinners().stream()
                .map(Car::getPosition))
                .containsExactly(3, 3, 3);
    }
}
