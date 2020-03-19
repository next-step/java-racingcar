package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {
    @DisplayName("null 또는 공백문자열이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validInputTest(String input) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView().insertNumberIntoField(input, InputType.CAR));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView().insertNumberIntoField(input, InputType.TRY));
    }

    @DisplayName("숫자가 아닌 문자열이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"@", "*", "A", "👍", "😱"})
    void validNumberTest(String input) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView().insertNumberIntoField(input, InputType.CAR));
    }

    @DisplayName("음수가 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-20", "-1", "-77"})
    void validateNegativeTest(String input) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView().insertNumberIntoField(input, InputType.CAR));
    }

    @DisplayName("입력값의 InputType에 따라 다른 InputView 필드에 저장된다.")
    @ParameterizedTest
    @CsvSource(value = {"5:5", "7:7"}, delimiter = ':')
    void insertValueToFieldTest(String input, int expected) {
        //when
        InputView inputView = new InputView();
        inputView.insertNumberIntoField(input, InputType.TRY);

        //then
        assertThat(inputView.getTryCount()).isEqualTo(expected);
    }
}