package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameTest {

    @Test
    void race_지정된_라운드만큼_경주를_진행한다() {
        Cars cars = new Cars(2);
        RandomNumber randomNumber = () -> 4;
        RacingGame game = new RacingGame(cars, randomNumber);

        RaceHistory history = game.race(2);

        assertThat(history.size()).isEqualTo(2);
        assertThat(history.getRound(0).positions()).containsExactly(1, 1);
        assertThat(history.getRound(1).positions()).containsExactly(2, 2);
    }

    @Test
    void race_입력된_라운드_수가_1미만이면_예외발생() {
        Cars cars = new Cars(2);
        RandomNumber randomNumber = () -> 4;
        RacingGame game = new RacingGame(cars, randomNumber);

        assertThatThrownBy(() -> game.race(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 수는 1이상이어야 합니다.");
    }
}
