package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    void test1() {
        int result1 = stringAddCalculator.splitAndSum(null);
        int result2 = stringAddCalculator.splitAndSum("");

        assertSoftly(softly -> {
            softly.assertThat(result1).isZero();
            softly.assertThat(result2).isZero();
        });
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void test2() {
        int result = stringAddCalculator.splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @Test
    void test3() {
        int result = stringAddCalculator.splitAndSum("1,2");

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    @Test
    void test4() {
        int result = stringAddCalculator.splitAndSum("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    void test5() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수를 전달할 경우 예외가 발생한다.")
    @Test
    void test6() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자는 양수여야 합니다.");
    }
}
