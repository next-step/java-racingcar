package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAdditionCalculatorTest {
    @Test
    @DisplayName("null 값을 입력할 경우 0을 반환")
    void null_입력할_경우_0_반환() {
        int expected = 0;
        int actual = StringAdditionCalculator.splitAndSum(null);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("빈 값을 입력할 경우 0을 반환")
    void 빈_값_입력할_경우_0_반환() {
        int expected = 0;
        int actual = StringAdditionCalculator.splitAndSum("");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void 숫자_하나를_입력할_경우_해당_숫자를_반환() {
        int expected = 5;
        int actual = StringAdditionCalculator.splitAndSum("5");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    void 숫자_두개를_컴마_구분자로_입력할_경우_두_숫자의_합을_반환() {
        int expected = 10;
        int actual = StringAdditionCalculator.splitAndSum("1,9");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자를 컴마(,)와 콜론(:) 구분자로 입력할 경우 숫자의 합을 반환")
    void 숫자를_컴마와_콜론_구분자로_입력할_경우_숫자의_합을_반환() {
        int expected = 6;
        int actual = StringAdditionCalculator.splitAndSum("1,2:3");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("“//”와 “\n” 문자 사이에 커스텀 구분자를 지정하여 숫자의 합을 반환")
    void 커스텀_구분자를_지정하여_숫자의_합을_반환() {
        int expected = 6;
        int actual = StringAdditionCalculator.splitAndSum("//;\n1;2;3");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("음수를 입력할 경우 RuntimeException 예외 발생")
    void 음수를_입력할_경우_RuntimeException_발생() {
        String input = "-1,2,3";
        assertThrows(RuntimeException.class, () -> StringAdditionCalculator.splitAndSum(input));
    }
}
