package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameTest {
    private static final int VALID_NUMBER_OF_CARS = 3;
    private static final int VALID_NUMBER_OF_ROUNDS = 5;

    @DisplayName("Game 객체가 잘 생성되는지")
    @Test
    void constructor() {
        final Game game = Game.of(VALID_NUMBER_OF_CARS, VALID_NUMBER_OF_ROUNDS);
        assertThat(game).isNotNull();
    }

    @DisplayName("자동차의 개수가 0보다 작으면 객체가 생성되지 않아야함")
    @Test
    void failToConstructWhenNumberOfCarsLessThenZero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Game.of(-1, VALID_NUMBER_OF_ROUNDS))
                .withMessageContaining("must be greater than");
    }

    @DisplayName("시도횟수가 0보다 작으면 객체가 생성되지 않아야함")
    @Test
    void failToConstructWhenNumberOfRoundsLessThenZero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Game.of(VALID_NUMBER_OF_CARS, -1))
                .withMessageContaining("must be greater than");
    }

    @DisplayName("게임 한 라운드가 잘 진행되어야함")
    @Test
    void playOneRound() {
        // given
        final Game game = Game.of(VALID_NUMBER_OF_CARS, VALID_NUMBER_OF_ROUNDS);
        // when
        final MovingStrategy moveOnlyStrategy = new MoveOnlyStrategy();
        game.playOneRound(moveOnlyStrategy);
        // then
        final Rounds gameResult = game.getResult();
        assertThat(gameResult).isNotNull();
        assertThat(gameResult.size()).isEqualTo(1);
        final Round lastRound = gameResult.getLast().orElseThrow(AssertionFailedError::new);
        lastRound.getCars().stream().forEach(
                car -> assertThat(car.getPosition()).isEqualTo(1)
        );
    }

    @DisplayName("게임이 종료된 경우 true")
    @Test
    void hasFinished() {
        // given
        final Game game = Game.of(VALID_NUMBER_OF_CARS, 0);
        // when
        final boolean actual = game.hasFinished();
        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("게임이 종료되지 않은경우 false")
    @Test
    void hasFinishedReturnsFalseWhenGameIsPlaying() {
        // given
        final Game game = Game.of(VALID_NUMBER_OF_CARS, VALID_NUMBER_OF_ROUNDS);
        // when
        final boolean actual = game.hasFinished();
        // then
        assertThat(actual).isFalse();
    }
}