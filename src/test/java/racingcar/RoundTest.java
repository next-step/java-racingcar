package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {

    @DisplayName("Round의 moveCars는 전진규칙이 true면 1 움직인다. ")
    @Test
    void roundMoveCarsTest() {
        Round round = new Round(new Cars(2));
        round.moveCars(() -> true);
        List<Integer> actual = round.getCarsPositionOfCurrentRound();
        List<Integer> expected = Arrays.asList(1,1);
        assertThat(actual).isEqualTo(expected);
    }
}
