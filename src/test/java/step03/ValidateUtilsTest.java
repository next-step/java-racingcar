package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {0})
    @DisplayName("int 하나만 파라미터로 전달받은 경우 값이 0 이상인지 체크")
    void inputIsZero(int input1) {
        assertThatThrownBy(() ->
                ValidateUtils.inputIsZero(input1)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 0 이상이어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0"})
    @DisplayName("int 두개를 파라미터로 전달받은 경우 값이 0 이상인지 체크")
    void inputIsZero2(int input1, int input2) {
        assertThatThrownBy(() ->
                ValidateUtils.inputIsZero(input1, input2)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 0 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {", 다섯글자가 넘어갑니다."})
    @DisplayName("구분자가 , 인 String을 파라미터로 전달받은 경우 string 0 < length <= 5 인지 확인")
    void inputStringSplitTextSize(String input) {
        assertThatThrownBy(() ->
                ValidateUtils.inputStringSplitTextSize(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
