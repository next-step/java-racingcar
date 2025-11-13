package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.random.RandomNumberGenerator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameTest {

    @Test
    void race_지정된_라운드만큼_경주를_진행하고_히스토리를_기록한다() {
        Cars cars = new Cars(List.of("자동차하나", "자동차둘"));
        RandomNumberGenerator randomNumberGenerator = () -> new RandomNumber(4);
        RacingGame game = new RacingGame(cars);

        RaceHistory history = game.race(2, randomNumberGenerator);

        assertThat(history.size()).isEqualTo(2);
        assertThat(history.lastRound().snapshots()).hasSize(2);
    }

    @Test
    void race_입력된_라운드_수가_1미만이면_예외발생() {
        Cars cars = new Cars(List.of("자동차하나", "자동차둘"));
        RandomNumberGenerator randomNumberGenerator = () -> new RandomNumber(4);
        RacingGame game = new RacingGame(cars);

        assertThatThrownBy(() -> game.race(0, randomNumberGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 수는 1이상이어야 합니다.");
    }
}
