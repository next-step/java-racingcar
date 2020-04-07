package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertjTest {

    String result = "assertj test code";

    @Test
    @DisplayName("시작 끝 문자열 확인 테스트")
    void stringContain() {
        assertThat(result).startsWith("assertj")
                .endsWith("code");
    }

    @Test
    @DisplayName("equal, not equal test")
    void equalAndNotEqual() {
        assertThat(result).isEqualTo("assertj test code")
                .isNotEqualTo("junit5");
    }

    @Test
    @DisplayName("size, contain")
    void sizeAndContain() {
        assertThat(result).hasSize(17)
                .contains("test")
                .doesNotContain("junit");
    }

    @Test
    @DisplayName("as 에러메시지 테스트")
    void asErrorMessage() {
        assertThat(result).as("error message test").contains("assertj");
    }

}
