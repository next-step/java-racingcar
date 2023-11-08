package racingcarwinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputViewTest {

    @DisplayName("input 으로 받은 자동차 이름의 길이가 5글자를 초과하면 exception 을 던진다.")
    @ParameterizedTest
    @CsvSource(value = {"'abcde,abc'", "'a,b,c,defgh"})
    void 자동차_이름_5글자_초과_시_exception(String input) {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.checkCarNameLength(input)).isInstanceOf(IllegalStateException.class);
    }
}