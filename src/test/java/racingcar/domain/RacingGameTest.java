package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.policy.MovePolicy;
import racingcar.random.RandomNumberGenerator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameTest {

    @Test
    void race_모든_자동차가_정상적으로_경주를_완료한다() {
        Cars cars = new Cars(List.of("자동차하나", "자동차둘"));
        RandomNumberGenerator randomNumberGenerator = () -> new RandomNumber(4);
        MovePolicy movePolicy = (randomNumber) -> true;
        RacingGame game = new RacingGame(cars, movePolicy);

        RaceHistory history = game.race(2, randomNumberGenerator);

        assertThat(history.winners()).containsExactlyInAnyOrder("자동차하나", "자동차둘");
    }
}
