package racingGameTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.InputView;
import racingGame.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class InputResultViewTest {

    private InputView inputView;
    private ResultView resultView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    @DisplayName("Test for 'isGreaterThan0'")
    @ParameterizedTest
    @CsvSource(value = {"1, 1", "12345, 12345", "333, 333"})
    void isGreaterThan0Test(int input, int expected) {
        assertThat(inputView.isGreaterThan0(input)).isEqualTo(expected);
    }

    @DisplayName("Test for 'printResult'")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10})
    void printResultTest(int input) {
        resultView.printResult(input);
    }
}
