package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "abc"})
    @DisplayName("양수가 아닌 값 입력시 예외처리")
    void inputExceptionTest(String input) {
        assertThatThrownBy(() -> {
            NumberUtil.getPositiveInteger(input);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("0 이상의 숫자만 입력해주세요");
    }


    @Test
    @DisplayName("양수값은 양수로 파싱")
    void inputParseTest() {
        int value = NumberUtil.getPositiveInteger("20221003");

        assertThat(value).isEqualTo(20221003);
    }
}
