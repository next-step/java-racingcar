package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {

    @DisplayName("레이싱 횟수 0 이하 입력 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    void 레이싱횟수검증(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.checkRoundValue(input);
        });
    }

    @DisplayName("입력값 공백 테스트")
    @NullAndEmptySource
    @ParameterizedTest
    void 입력값공백테스트(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.checkCarNamesValue(inputValue);
        });
    }

    @DisplayName("입력값 분리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"name1,name2,name3"})
    void 입력값분리테스트(String inputValue) {
        String[] stringArray = InputView.splitString(inputValue);
        assertThat(stringArray).isEqualTo(new String[]{"name1", "name2", "name3"});
    }

}
