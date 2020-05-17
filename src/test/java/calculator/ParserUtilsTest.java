package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import javax.swing.text.html.parser.Parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class ParserUtilsTest {

    @DisplayName("입력값이 숫자가 아닐때 에러 발생 테스트ㄴ")
    @Test
    void getNumberError() {
        String[] strings = {"a"};
        assertThatIllegalArgumentException().isThrownBy(() -> ParserUtils.getNumber(strings[0]));
    }

    @DisplayName("입력값이 정상적일때 동작 테스트")
    @Test
    void getNumberSuccess() {
        String[] strings = {"1", "*", "3", "+", "7"};
        int result = ParserUtils.getNumber(strings[0]);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("옳바르게 입력된 문자를 배열로 변환 테스트 ")
    @Test
    void toArraySuccess() {
        String input = "2 + 3 + 4 / 3";
        String[] result = ParserUtils.toArray(input);
        assertThat(result.length).isEqualTo(7);
    }

    @DisplayName("잘못 입력된 문자를 배열로 변환 테스트 ")
    @Test
    void toArrayError() {
        String input = "2 + 3 * 4 / ";
        assertThatIllegalArgumentException().isThrownBy(() -> ParserUtils.toArray(input));
    }

    @DisplayName("null 또는 공백이 입력된 문자를 배열로 변환 테스트 ")
    @ParameterizedTest
    @NullAndEmptySource
    void toArrayNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> ParserUtils.toArray(input));
    }


}