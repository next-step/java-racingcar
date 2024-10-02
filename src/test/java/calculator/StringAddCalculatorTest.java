package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {


    @ParameterizedTest
    @NullAndEmptySource
    void 빈문자열_또는_null(String value) {

        assertThat(splitAndSum(value)).isZero();
    }

    @Test
    void 컴마_구분자_합_반환() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 컴마_와_콜론_구분자_두개_허용() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 숫자_하나_구분자_없이() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 구분자만_입력() {
        assertThat(splitAndSum(":")).isEqualTo(0);
    }

    @Test
    void 커스텀_구분자_한단어() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_여러단어() {
        assertThat(splitAndSum("//;:\n1;:2;:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_이외_입력() {

        assertThatThrownBy(() ->
                splitAndSum("//;\n1:2;3")
        ).isInstanceOf(NumberFormatException.class);

    }

    @Test
    void 음수_입력() {

        assertThatThrownBy(() ->
                splitAndSum("//;\n-1;2;3")
        ).isInstanceOf(RuntimeException.class);

    }

}
