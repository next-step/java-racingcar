package racinggame.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Test
    void carNames_정상_입력() {
        // given
        final String userInput = "car1,car2";
        final InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // when
        final String inputCarNames = InputView.inputCarNames();

        // then
        assertThat(inputCarNames).isEqualTo(userInput);
    }

    @Test
    void 시도횟수_정상_입력() throws IllegalAccessException {
        // given
        final String inputTrial = "5";
        final InputStream inputStream = new ByteArrayInputStream(inputTrial.getBytes());
        System.setIn(inputStream);

        // when
        final String trial = InputView.inputTrial();

        // then
        assertThat(trial).isEqualTo(inputTrial);
    }

    @ValueSource(strings = {"1 0", " 10", " 1 0 ", "10 ", "1   0  "})
    @ParameterizedTest
    void getTrial_불필요한_공백이_들어왔을_때_제거(final String inputTrial) throws IllegalAccessException {
        InputStream inputStream = new ByteArrayInputStream(inputTrial.getBytes());
        System.setIn(inputStream);

        // when
        final String trial = InputView.inputTrial();

        // then
        assertThat(trial).isEqualTo("10");
    }

    @Test
    void 시도횟수는_숫자인지_검증하는_로직_성공() {
        // given
        InputStream inputStream = new ByteArrayInputStream("5".getBytes());
        System.setIn(inputStream);

        // then
        assertDoesNotThrow(() -> InputView.inputTrial());
    }

    @Test
    void 시도횟수가_숫자가_아니면_재입력() {
        // given
        InputStream inputStream = new ByteArrayInputStream("a".getBytes());
        System.setIn(inputStream);

        // then
        assertThrows(NoSuchElementException.class, () -> InputView.inputTrial());
    }

    @ValueSource(strings = {" ", "", "\n", "\t"})
    @ParameterizedTest
    void 시도횟수에_공백이_들어오면_재입력(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // then
        assertThrows(NoSuchElementException.class, () -> InputView.inputTrial());
    }
}
