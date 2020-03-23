package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.Car;
import study.racingcar.domain.MovableDistance;
import study.racingcar.domain.RacingGame;
import study.racingcar.domain.RacingGameData;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private final List<String> EXAMPLE_CARS =
            Arrays.asList("pobi", "crong", "honux");
    private MovableDistance movableDistance;

    @BeforeEach
    void setUp() {
        movableDistance = () -> 1;
    }

    @DisplayName("입력한 수행 횟수만큼 게임을 진행할 수 있다.")
    @Test
    void moveByTheNumberOfTimes() {
        RacingGame racingGame =
                new RacingGame(new RacingGameData(EXAMPLE_CARS, 2),
                        movableDistance);

        assertThat(racingGame.isMovable()).isTrue();
        racingGame.move();
        assertThat(racingGame.isMovable()).isTrue();
        racingGame.move();
        assertThat(racingGame.isMovable()).isFalse();
    }

    @DisplayName("모든 차가 수행 횟수만큼 전진할 수 있다.")
    @Test
    void success() {
        RacingGame racingGame =
                new RacingGame(new RacingGameData(EXAMPLE_CARS, 3),
                        movableDistance);
        for (int i = 0; i < 3; i++) {
            racingGame.move();
        }

        assertThat(racingGame.getCars().size()).isEqualTo(3);
        assertThat(racingGame.getCars().stream().map(Car::getPosition))
                .containsExactly(3, 3, 3);
    }

    @DisplayName("우승자는 두명 이상일 수 있다.")
    @Test
    void winnerCanOverTwo() {
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
        RacingGame racingGame =
                new RacingGame(new RacingGameData(EXAMPLE_CARS, 3),
                        movableDistance);
        for (int i = 0; i < 3; i++) {
            racingGame.move();
        }


        List<Car> winner = racingGame.getWinner();
        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.stream().map(Car::getName)).contains("pobi", "crong");
    }
}
