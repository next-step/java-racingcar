package racing_car_with_winner;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racing_car_with_winner.exception.InvalidInputException;

class GameAttemptCountTest {

    @DisplayName("시도회수는 음수가 불가능하다")
    @Test
    void create_시도회수를_입력받는다() {
        Assertions.assertThatThrownBy(() -> {
            new GameAttemptCount(-1);
        }).isInstanceOf(InvalidInputException.class);
    }
}