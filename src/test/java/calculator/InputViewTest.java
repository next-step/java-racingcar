package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    @DisplayName("공백 또는 null을 입력받으면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateTest(String input) {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new InputView(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 3:3", "13 - 2 / 2:5", "3 * 5 - 2 + 7:7"}, delimiter = ':')
    void splitTest(String input, int expectedLength){
        //given
        InputView inputView = new InputView(input);

        //when
        String[] stringArr = inputView.split();

        //then
        assertThat(stringArr.length).isEqualTo(expectedLength);
    }
}
