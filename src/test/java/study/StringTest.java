package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("split을 사용해서 특수문자를 기준으로 문자열을 나누는 테스트.")
    void splitTest() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring을 사용해서 원하는 문자들만 추출하는 테스트.")
    void substringTest() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 사용해서 StringIndexOutOfBoundsException을 발생시키고, 검증하기 위해 assertThatThrownBy 테스트.")
    void charAtThrownByTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("fail");
    }

    @Test
    @DisplayName("charAt을 사용해서 StringIndexOutOfBoundsException을 발생시키고, 검증하기 위해 assertThatExceptionOfType 테스트.")
    void charAtExceptionOfTypeTest() {
        int idx = 4;
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(idx);
                }).withMessage("char [%d] is null",idx);
    }
}
