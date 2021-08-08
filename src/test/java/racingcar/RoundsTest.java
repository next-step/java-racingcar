package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundsTest {

    @DisplayName("Rounds의 moveCarsForEachRound는 전진규칙이 true면 1 움직인다. ")
    @Test
    void roundMoveCarsTest() {
        Rounds actual = new Rounds(5);
        actual.moveCarsForEachRound(new Cars(2), new MoveRuleByRandomValue(true));

        Round[] rounds = new Round[5];
        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = new Round(new Cars(new Car(1), new Car(1)));
        }

        Rounds expected = new Rounds(rounds);
        assertThat(actual).isEqualTo(expected);
    }

}
