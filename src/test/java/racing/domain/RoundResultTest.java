package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.domain.rule.MustGoRacingRule;
import racing.domain.rule.RacingRule;

class RoundResultTest {

    @Test
    void findWinnerTest() {
        Cars cars = new Cars(Arrays.asList(
            new Car("2",0),
            new Car("1",1),
            new Car("1-1",1)
        ));
        RacingRule racingRule = new MustGoRacingRule();
        RoundResult roundResult = cars.race(racingRule);

        assertThat(roundResult.findWinners())
                .containsExactly(
                        new Car("1", 2),
                        new Car("1-1", 2)
                );

    }
}