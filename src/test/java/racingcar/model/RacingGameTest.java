package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovingGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.Car.DEFAULT_POSITION;
import static racingcar.model.RacingGame.MIN_ROUND;

public class RacingGameTest {

    @DisplayName("레이싱 실행 한번한 결과를 반환한다")
    @Test
    void playOfOneRound() {
        RacingGame racingGame = racingGameOf(new Car("test1", DEFAULT_POSITION),
                                             new Car("test2", DEFAULT_POSITION),
                                             new Car("test3", DEFAULT_POSITION));

        Cars result = racingGame.playOfOneRound();

        assertThat(result.getCars())
                .extracting(Car::getPosition).containsOnly(DEFAULT_POSITION + 1);
    }

    private RacingGame racingGameOf(Car... cars) {
        return new RacingGame(1, new Cars(Arrays.asList(cars), new MovingGenerator()));
    }

    @Test
    @DisplayName("실행 횟수가 " + MIN_ROUND + "이면 게임종료")
    void timeZeroThenGameOver() {
        RacingGame racingGame = new RacingGame(0, null);
        assertThat(racingGame.isGameOver()).isTrue();
    }

    @Test
    @DisplayName("실행 횟수가 " + MIN_ROUND + "이 아닐 시 게임진행")
    void timeNoZeroThenGameOver() {
        RacingGame racingGame = new RacingGame(3, null);
        assertThat(racingGame.isGameOver()).isFalse();
    }
}