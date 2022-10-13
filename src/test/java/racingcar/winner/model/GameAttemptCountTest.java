package racingcar.winner.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.winner.exception.InvalidInputException;

class GameAttemptCountTest {

    @DisplayName("시도회수는 음수가 불가능하다")
    @Test
    void create_시도회수를_입력받는다() {
        assertThatThrownBy(() -> {
            new GameAttemptCount(-1);
        }).isInstanceOf(InvalidInputException.class);
    }

    @Test
    void play_정해진만큼만시도한다() {
        GameAttemptCount gameAttemptCount = new GameAttemptCount(1);

        gameAttemptCount = gameAttemptCount.play();

        Assertions.assertThat(gameAttemptCount.isEnded()).isTrue();
    }
}