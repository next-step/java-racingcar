package calculator;

import caculator.InputProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputProcessorTest {
    InputProcessor inputProcessor = new InputProcessor();

    @Test
    @DisplayName("잘라진 배열의 길이가 홀수가 아닌 일 짝수일 경우 IllegalArgumentException")
    void testExpectedExceptionSplitInputLength() {
        assertThatThrownBy(() -> inputProcessor.process("1 +"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘라진 배열의 값이 숫자가 아닐 경우 IllegalArgumentException")
    void testExpectedExceptionSplitInputType() {
        assertThatThrownBy(() -> inputProcessor.process("& 4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 Null이나 빈 문자열의 경우 IllegalArgumentException")
    @NullAndEmptySource
    void testExpectedExceptionNullOrEmpty(String input) {
        assertThatThrownBy(() -> inputProcessor.process(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
