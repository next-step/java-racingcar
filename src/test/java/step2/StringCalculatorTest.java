package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class StringCalculatorTest {


    private StringCalculator stringCalculator;

    @BeforeEach
    private void setStringCalculator() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    void textCheck() {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(stringCalculator.addOperation("")).isEqualTo(0),
                () -> assertThat(stringCalculator.addOperation(null)).isEqualTo(0)
        );
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void textCheckProvidesANumber() {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(stringCalculator.addOperation("1")).isEqualTo(1),
                () -> assertThat(stringCalculator.addOperation("22")).isEqualTo(22)
        );
    }

    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @Test
    void addOperationSeparateByRest() {
        assertThat(stringCalculator.addOperation("1,2")).isEqualTo(3);
    }

    @DisplayName("구분자를 컴마 이외에 콜론을 사용할 수 있다.")
    @Test
    void addOperationSeparateByRestAndColon() {
        assertThat(stringCalculator.addOperation("1,2:3")).isEqualTo(6);
    }

    @DisplayName("//와 \\n로 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    void addOperationSeparateWithCustomSeparator() {
        assertThat(stringCalculator.addOperation("//;\n1;2;3"));
    }

    @DisplayName("음수 또는 숫자 이외의 값을 전달할 경우 RuntimeException 예외가 발생한다")
    @Test
    public void addOperation_negative() {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThatThrownBy(() -> stringCalculator.addOperation("-1,2,3"))
                        .isInstanceOf(RuntimeException.class),
                () -> assertThatThrownBy(() -> stringCalculator.addOperation("1,a,3"))
                        .isInstanceOf(RuntimeException.class)

        );
    }
}
