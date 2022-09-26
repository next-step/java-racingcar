package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void StringAddCalculatorTestInit() {
        this.stringAddCalculator = new StringAddCalculator();
    }

    //구분자가 입력되지 않은경우 테스트
    @Test
    @DisplayName("sumBySeparator / 구분자없음 / 성공: null 입력시 0이 반환되어야함")
    void sumBySeparator_noSeparator_null() {
        int result = this.stringAddCalculator.sumBySeparator(null);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("sumBySeparator 성공: 빈문자열 입력시 0이 반환되어야함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @ValueSource(strings = {"", "//\n", "//;\n", "//;!\n"})
    public void sumBySeparator_빈문자열(String input) {
        System.out.println("input = " + input);
        int result = this.stringAddCalculator.sumBySeparator(input);
        assertThat(result).isEqualTo(0);
        System.out.println("테스트통과" + input);
    }

    @DisplayName("sumBySeparator 성공: 숫자하나를 문자열로 입력시 그숫자가 숫자형으로 반환되어야함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @ValueSource(strings = {"456", "//\n456", "//;\n456", "//;!\n456"})
    void sumBySeparator_숫자하나(String input) {
        int result = this.stringAddCalculator.sumBySeparator(input);
        assertThat(result).isEqualTo(456);
    }

    @DisplayName("sumBySeparator 성공: 숫자두개를 구분자한개로 구분한 경우")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @ValueSource(strings = {"1,20", "//\n1:20", "//;\n1;20", "//;!\n1!20"})
    void sumBySeparator_숫자두개(String input) {
        int result = this.stringAddCalculator.sumBySeparator(input);
        assertThat(result).isEqualTo(21);
    }

    @DisplayName("sumBySeparator 성공: 숫자세개를 2가지 구분자로 구분한 경우")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @ValueSource(strings = {"1,2:10", "//\n1:2,10", "//;\n1,2;10", "//;!\n1;2!10"})
    void sumBySeparator_숫자세개(String input) {
        int result = this.stringAddCalculator.sumBySeparator(input);
        assertThat(result).isEqualTo(13);
    }

    @DisplayName("sumBySeparator 실패: 숫자가 음수인 경우 RuntimeException 발생")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @ValueSource(strings = {"-123", "//\n1,-123", "//;\n1;-123", "//;!\n1;-123!2"})
    void sumBySeparator_음수(String input) {
        Throwable thrown = catchThrowable(() -> { this.stringAddCalculator.sumBySeparator(input); });
        assertThat(thrown).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("sumBySeparator 실패: 숫자로 변환 불가능한 문자인 경우 RuntimeException 발생")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @ValueSource(strings = {"1;2", "//\n1,abc", "//;\ntrue;1", "//;!\na;b!2"})
    void sumBySeparator_문자(String input) {
        Throwable thrown = catchThrowable(() -> { this.stringAddCalculator.sumBySeparator(input); });
        assertThat(thrown).isInstanceOf(RuntimeException.class);
    }
}
