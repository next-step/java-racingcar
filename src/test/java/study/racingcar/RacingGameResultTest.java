package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingGameResultTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = getSampleRacingGame();
    }

    @DisplayName("우승자는 두명 이상일 수 있다.")
    @Test
    void winnerCanOverTwo() {
        for (int i = 0; i < 3; i++) {
            racingGame.move();
        }
        RacingGameResult racingGameResult =
                new RacingGameResult(racingGame);
        List<Car> winner = racingGameResult.getWinner();
        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.stream().map(Car::getName)).contains("pobi", "crong");
    }

    @DisplayName("끝나지 않은 게임의 게임 결과를 얻을경우 에러발생")
    @Test
    void tryToNotFinishedGame() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new RacingGameResult(racingGame);
                });
    }

    private RacingGame getSampleRacingGame() {
        MovableDistance movableDistance = new MovableDistance() {
            int i = -1;

            @Override public int getDistance() {
                i++;
                if ((i % 3 == 0) || (i % 3 == 1)) {
                    return 1;
                }
                return 0;
            }
        };

        return new RacingGame(new RacingGameData(
                Arrays.asList("pobi", "crong", "honux"), 3),
                movableDistance
        );
    }
}
