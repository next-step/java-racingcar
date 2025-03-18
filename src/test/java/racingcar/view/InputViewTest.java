package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView(); // 중복 제거
    }

    @DisplayName("숫자 문자열을 입력했을 때 숫자로 변환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "42", "9876"})
    void convertToInt_문자(String input) {
        int result = inputView.convertToInt(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("공백이 포함된 숫자 문자열을 입력했을 때, 공백을 제거하고 숫자로 변환한다.")
    @ParameterizedTest
    @ValueSource(strings = {" 123 ", "     456     ", "\t789\t"})
    void convertToInt_공백_문자(String input) {
        int result = inputView.convertToInt(input);
        assertThat(result).isEqualTo(Integer.parseInt(input.trim()));
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "123abc", "!@#$", " "})
    void convertToInt_예외(String input) {
        assertThatThrownBy(() -> inputView.convertToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER + input);
    }
}
