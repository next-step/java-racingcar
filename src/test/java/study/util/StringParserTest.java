package study.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static study.util.StringParser.*;

class StringParserTest {

    @DisplayName("쉼표 구분자로 문자열을 분리한다")
    @Test
    void splitWithComma() {
        assertThat(split("1,2,3")).containsExactly("1", "2", "3");
    }

    @DisplayName("콜론 구분자로 문자열을 분리한다")
    @Test
    void splitWithColon() {
        assertThat(split("1:2:3")).containsExactly("1", "2", "3");
    }

    @DisplayName("쉼표와 콜론을 혼합하여 분리한다")
    @Test
    void splitWithMixedSeparator() {
        assertThat(split("1,2:3")).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자로 문자열을 분리한다")
    @Test
    void splitWithCustomSeparator() {
        assertThat(split("//;\n1;2;3")).containsExactly("1", "2", "3");
    }

    @DisplayName("단일 숫자는 배열의 한 요소로 반환된다")
    @Test
    void splitSingleNumber() {
        assertThat(split("5")).containsExactly("5");
    }

    @DisplayName("여러 문자 커스텀 구분자도 처리한다")
    @Test
    void splitWithMultiCharCustomSeparator() {
        assertThat(split("//z\n1z2z3")).containsExactly("1", "2", "3");
    }
}