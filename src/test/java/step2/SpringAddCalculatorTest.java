package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.delimiter.DelimiterNumberParserFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

//TODO : NullAndEmptySource와 @ParameterizedTest로 중복 제거
class SpringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator(new DelimiterNumberParserFactory());
    }

    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = stringAddCalculator.splitAndSum(null);
        assertThat(result).isZero();

        result = stringAddCalculator.splitAndSum("");
        assertThat(result).isZero();
    }

    @Test
    void splitAndSum_숫자하나() {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}