package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RoundsTest {

    @DisplayName("Rounds의 moveCarsForEachRound는 전진규칙이 true면 1 움직인다. ")
    @Test
    void roundMoveCarsTest() {
        Rounds rounds = new Rounds(2);
        rounds.moveCarsForEachRound(new Cars(Arrays.asList("Dave", "Bob", "Kevin")), () -> true);
        List<List<Integer>> actual = rounds.getCarsPositionForEachRound();
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(2,2,2));
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Car의 수는 1이상의 정수이다.")
    @Test
    void numberOfRoundsHasToBeIntegerNotLessThanOne() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Rounds(0)).withMessageMatching("시도 회수는 1이상의 정수입니다.");
    }

}
