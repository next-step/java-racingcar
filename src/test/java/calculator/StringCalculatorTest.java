package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        this.stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값일 경우 0 반환")
    void 빈문자열_null() {

        assertThat(stringCalculator.splitAndSum(null))
                .isEqualTo(0);
        assertThat(stringCalculator.splitAndSum(""))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나일때 해당 숫자 반환")
    void 숫자_하나() {
        assertThat(stringCalculator.splitAndSum("1"))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("콜론 구분자로 각각의 숫자 구분하여 합을 반환")
    void 컴마구분자() {
        assertThat(stringCalculator.splitAndSum("1,2"))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("콜론과 컴마 구분자로 각각의 숫자 구분하여 합을 반환")
    void 콜론과_컴마_구분자() {
        assertThat(stringCalculator.splitAndSum("1,2:3"))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함되어있을떄 exception 반환")
    void 음수() {
        assertThatThrownBy(() -> stringCalculator.splitAndSum("-1,2:3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("//”와 \\n 문자 사이에 커스텀 구분자를 넣을경우 구분 가능")
    void 커스텀_구분자() {
        assertThat(stringCalculator.splitAndSum("//a\n1:2,3a6"))
                .isEqualTo(12);
    }
}
