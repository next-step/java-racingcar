package step2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step2.FourOperation.DivideOperation;
import step2.FourOperation.MinusOperation;
import step2.FourOperation.MultiplyOperation;
import step2.FourOperation.PlusOperation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class Step2 {


    private Calculator calculator;
    private Method method;
    @BeforeEach
    void setUp() throws NoSuchMethodException {
        calculator = new Calculator();
    }

    @DisplayName("더하기 테스트")
    @Test
    public void plus() {

        assertThat(new PlusOperation().operation(1,2)).isEqualTo(3);
    }

    @DisplayName("빼기 테스트")
    @Test
    public void minus() {
        assertThat(new MinusOperation().operation(20,2)).isEqualTo(18);
    }

    @DisplayName("나누기 테스트")
    @Test
    public void divide() {
        assertThat(new DivideOperation().operation(14,2)).isEqualTo(7);
    }

    @DisplayName("곱하기 테스트")
    @Test
    public void multiply() {
        assertThat(new MultiplyOperation().operation(20,2)).isEqualTo(40);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 ")
    @ParameterizedTest
    @NullAndEmptySource
    public void 공백문자열널테스트(String input) throws NoSuchMethodException {

        method = calculator.getClass().getDeclaredMethod("isEmptyInput",String.class);
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    calculator.fourRuleCalculations(input);
                });
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    method.invoke(Calculator.class, input);
                });
    }

    @DisplayName("잘 계산 되는지 테스트")
    @Test
    public void 계산테스트() {
        assertThat(calculator.fourRuleCalculations("2 + 3 * 4 / 2")).isEqualTo(10);
    }

}
