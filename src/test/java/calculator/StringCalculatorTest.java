package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum_null_또는_빈_문자열(String input) {
        int result = StringCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() {
        int result = StringCalculator.splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표_구분자() {
        int result = StringCalculator.splitAndSum("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_콜론_구분자() {
        int result = StringCalculator.splitAndSum("1:2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_커스텀_구분자() {
        int result = StringCalculator.splitAndSum("//@\n1@2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_음수() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 입력할 수 없습니다: -1");
    }
}
