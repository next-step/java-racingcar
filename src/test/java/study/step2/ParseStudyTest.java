package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParseStudyTest {

    @ParameterizedTest
    @ValueSource(strings = {" 3", "3 "})
    @DisplayName("Integer.parseInt() 공백포함 문자열 NumberFormatException 발생")
    public void parseIntTest(String input) {
        assertThatThrownBy(() -> {
            Integer.parseInt(input);
        }).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" 3", "3 "})
    @DisplayName("Double.parseDouble() 공백포함 문자열도 그냥 숫자로 변환 (trim())")
    public void parseDoubleTest(String input) {
        assertThat(Double.parseDouble(input)).isEqualTo(3);
    }

}
