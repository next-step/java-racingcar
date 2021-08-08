package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RoundsTest {

    @DisplayName("Rounds의 moveCarsForEachRound는 전진규칙이 true면 1 움직인다. ")
    @Test
    void roundMoveCarsTest() {
        Rounds actual = new Rounds(5);
        actual.moveCarsForEachRound(new Cars(2), () -> true);

        Round[] rounds = new Round[5];
        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = new Round(new Cars(new Car(i + 1), new Car(i + 1)));
        }

        Rounds expected = new Rounds(rounds);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Car의 수는 1이상의 정수이다.")
    @Test
    void numberOfRoundsHasToBeIntegerNotLessThanOne() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Rounds(0)).withMessageMatching("시도 회수는 1이상의 정수입니다.");
    }

}
