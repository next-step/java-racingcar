package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputTest {
    private final Input input = new Input();
    private String testInput;

    @BeforeEach
    void setUP() {
        testInput = "2 + 3";
    }

    @Test
    @DisplayName("splitterTest 정상 케이스")
    void splitterTest() {
        // given
        String[] expected = {"2", "+", "3"};
        String[] actual = input.isSplit(testInput);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("splitterTest 예외 케이스")
    void isSplitExceptionTest(String testValue) {
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> input.isSplit(testValue));
    }
}
