package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"})
    void 자동차는_1대_이상_10대_이하로_제한한다(String input) {
        InputView inputView = new InputView(input);
        assertThatCode(() -> inputView.askCarCount()).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-100", "-1", "0", "11", "100"})
    void 자동차는_1대_미만_10대_초과하여_설정할_수_없다(String input) {
        InputView inputView = new InputView(input);
        assertThatThrownBy(() -> inputView.askCarCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 수는 1 ~ 10대 사이로 설정해야 합니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "english", "1.1"})
    @DisplayName("자동차 수는 1~10의 정수 이외의 값은 사용할 수 없다.")
    void 자동차_수_입력_시_숫자만_사용가능(String input) {
        InputView inputView = new InputView(input);
        assertThatThrownBy(() -> inputView.askCarCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 10 사이의 정수만 사용할 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "4", "7", "30"})
    void 이동_횟수는_1회_이상으로_제한한다(String input) {
        InputView inputView = new InputView(input);
        assertThatCode(() -> inputView.askRoundCount()).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-100", "-1", "0"})
    void 이동_횟수는_1회_미만으로_설정할_수_없다(String input) {
        InputView inputView = new InputView(input);
        assertThatThrownBy(() -> inputView.askRoundCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 1회 이상으로 설정해야 합니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "english", "1.1"})
    void 이동_횟수_입력_시_자연수만_사용가능(String input) {
        InputView inputView = new InputView(input);
        assertThatThrownBy(() -> inputView.askRoundCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상의 숫자만 사용할 수 있습니다.");
    }
}