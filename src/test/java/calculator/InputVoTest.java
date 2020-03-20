package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputVoTest {

    @DisplayName("null, 공백 체크")
    @Test
    void validateNull() {
        //given
        String test1 = "";
        String test2 = " ";
        String test3 = null;

        //when
        //then
        assertThatThrownBy(() -> {
            new InputVo(test1);
            new InputVo(test2);
            new InputVo(test3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백을 구분자로 split")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 3 / 2:5", "4 * 2 / 1 - 3:7"}, delimiter = ':')
    public void splitInput(String input, int size)  {
        //then
        assertThat(new InputVo(input).getInputSplit().length).isEqualTo(size);
    }
}