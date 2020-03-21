package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @DisplayName("입력값이 정수인지 : success")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "100:100"}, delimiter = ':')
    public void validateInteger_success(String input, int expect) throws Exception {
        //then
        assertThat(new InputView(input));
    }

    @DisplayName("입력값이 정수인지 : fail")
    @ParameterizedTest
    @ValueSource(strings = {"a", "@", "3.3"})
    public void validateInteger_fail(String input) throws Exception {
        //then
        assertThatThrownBy(() -> {
            new InputView(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
