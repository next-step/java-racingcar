package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    MovableDistance movableDistance;


    @BeforeEach
    void setUp() {
        movableDistance = () -> 1;
    }

    @DisplayName("차 댓수와 시도 횟수가 1 이상이다.")
    @Test
    void success() {
        RacingGame racingGame =
                new RacingGame(new RacingGameVo(3, 4), movableDistance);

        int[] carPositions = racingGame.move();
        assertThat(carPositions.length).isEqualTo(3);
        assertThat(racingGame.isMovable()).isTrue();
        racingGame.move();
        racingGame.move();
        int[] lastMovedCarPositions = racingGame.move();
        assertThat(lastMovedCarPositions).containsExactly(4, 4, 4);
        assertThat(racingGame.isMovable()).isFalse();
    }

    @DisplayName("차 댓수와 시도 횟수가 0이여도 된다.")
    @Test
    void nothingToDo() {
        RacingGame racingGameWithNoCar =
                new RacingGame(new RacingGameVo(0, 2), movableDistance);
        int[] carPositionsWithNoCar = racingGameWithNoCar.move();
        assertThat(carPositionsWithNoCar.length).isEqualTo(0);
        assertThat(racingGameWithNoCar.isMovable()).isTrue();
        racingGameWithNoCar.move();
        assertThat(racingGameWithNoCar.isMovable()).isFalse();

        RacingGame racingGameWithZeroTime =
                new RacingGame(new RacingGameVo(2, 0), movableDistance);
        assertThat(racingGameWithZeroTime.isMovable()).isFalse();
        int[] carPositionsWithZeroTime = racingGameWithZeroTime.move();
        assertThat(carPositionsWithZeroTime.length).isEqualTo(2);
    }
}
