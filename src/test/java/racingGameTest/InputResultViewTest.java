package racingGameTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingGame.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

public class InputResultViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("Test for 'isGreaterThan0'")
    @ParameterizedTest
    @CsvSource(value = {"1, 1", "12345, 12345", "333, 333"})
    void isGreaterThan0Test(int input, int expected) {
        assertThat(inputView.isGreaterThan0(input)).isEqualTo(expected);
    }

}
