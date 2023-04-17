package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringAdditionCalculatorTest {
    StringAdditionCalculator stringAdditionCalculator;

    @BeforeAll
    void setUp() {
        this.stringAdditionCalculator = new StringAdditionCalculator();
    }

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열에서 숫자 합하기 테스트")
    void splitAndSum_defaultDelimiter_test() throws Exception {
        assertThat(stringAdditionCalculator.splitAndSum("1:2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("'//'와 '\\n' 사이에 위치하는 문자를 구분자로 가지는 문자열에서 숫자 합하기 테스트")
    void splitAndSum_customDelimiter_test() throws Exception {
        assertThat(stringAdditionCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1:2", "3:w"})
    @DisplayName("숫자 이외의 값 또는 음수가 전달되면 RuntimeException 발생")
    void splitAndSum_exception_test(String str) throws Exception {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    stringAdditionCalculator.splitAndSum(str);
                }).withMessageMatching("include unexpected value");
    }
}
