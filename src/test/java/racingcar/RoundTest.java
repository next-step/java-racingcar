package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {

    @DisplayName("Round의 moveCars는 전진규칙이 true면 1 움직인다. ")
    @Test
    void roundMoveCarsTest() {
        Round actual = new Round(new Cars(2));
        actual.moveCars(() -> true);
        Round expected = new Round(new Cars(new Car(1), new Car(1)));
        assertThat(actual).isEqualTo(expected);
    }
}
