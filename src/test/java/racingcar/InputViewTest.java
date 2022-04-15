package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    // getCarNames


    @Test
    void parseInputShouldReturnCarNames() {
        String[] expected = {"pobi", "crong", "honux"};
        assertThat(InputView.parseInput("pobi,crong,honux")).isEqualTo(expected);
    }

    @Test
    void inputShouldBeOneToNine() {
        assertThat(InputView.isInputRange(8)).isTrue();
        assertThat(InputView.isInputRange(11)).isFalse();
    }
    // getTryNumber
}
