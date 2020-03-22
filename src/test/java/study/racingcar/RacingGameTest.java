package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private final String[] EXAMPLE_CARS = "pobi,crong,honux".split(",");
    private MovableDistance movableDistance;

    @BeforeEach
    void setUp() {
        movableDistance = () -> 1;
    }

    @DisplayName("차 댓수와 시도 횟수가 1 이상이다.")
    @Test
    void success() {
        RacingGame racingGame =
                new RacingGame(new RacingGameData(EXAMPLE_CARS, 4),
                        movableDistance);

        List<Car> cars = racingGame.move();
        assertThat(cars.size()).isEqualTo(3);
        assertThat(racingGame.isMovable()).isTrue();
        racingGame.move();
        racingGame.move();
        racingGame.move();
        assertThat(cars.stream().map(Car::getPosition))
                .containsExactly(4, 4, 4);
        assertThat(racingGame.isMovable()).isFalse();
    }

    @DisplayName("차 댓수와 시도 횟수가 0이여도 된다.")
    @Test
    void nothingToDo() {
        RacingGame racingGameWithNoCar =
                new RacingGame(new RacingGameData(new String[0], 2),
                        movableDistance);
        List<Car> carPositionsWithNoCar = racingGameWithNoCar.move();
        assertThat(carPositionsWithNoCar.size()).isEqualTo(0);
        assertThat(racingGameWithNoCar.isMovable()).isTrue();
        racingGameWithNoCar.move();
        assertThat(racingGameWithNoCar.isMovable()).isFalse();

        RacingGame racingGameWithZeroTime =
                new RacingGame(new RacingGameData(EXAMPLE_CARS, 0),
                        movableDistance);
        assertThat(racingGameWithZeroTime.isMovable()).isFalse();
        List<Car> carPositionsWithZeroTime = racingGameWithZeroTime.move();
        assertThat(carPositionsWithZeroTime.size()).isEqualTo(3);
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
        racingGame.move();
        racingGame.move();
        racingGame.move();

        List<Car> winner = racingGame.getWinner();
        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.stream().map(Car::getName)).contains("pobi", "crong");
    }
}
