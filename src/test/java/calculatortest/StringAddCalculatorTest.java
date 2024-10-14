package calculatortest;

import calculator.StringAddCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

//    @ParameterizedTest
    @ParameterizedTest
    @NullAndEmptySource
    void 빈문자열_혹은_null값이_들어오면_0(String value) {
        assertThat(StringAddCalculator.splitAndSum(value)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum(value)).isEqualTo(0);
    }

    @Test
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다() {
        int value = StringAddCalculator.splitAndSum("7");
        assertThat(value).isEqualTo(7);
    }

    @Test
    void 숫자_두개를_컴마_구분자로_입력할_경우_두_숫자의_합을_반환한다() throws Exception {
        int i = StringAddCalculator.splitAndSum("3,4");
        assertThat(i).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3,4:6", "3:4:6"})
    void 구분자를_컴마_이외에_콜론을_사용할_수_있다(String input) throws Exception {
        int i = StringAddCalculator.splitAndSum(input);
        assertThat(i).isEqualTo(13);
    }

    @Test
    void 문자_사이에_커스텀_구분자를_지정할_수_있다() {
        // 일단 모르겠는데 이거하고 좀 살펴보자 (정규표현식)
        int i = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(i).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "r,2,-1"})
    void 음수를_전달할_경우_RuntimeException_예외가_발생해야_한다(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input)).isInstanceOf(RuntimeException.class);
    }
}
