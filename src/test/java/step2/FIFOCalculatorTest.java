package step2;

import helper.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class FIFOCalculatorTest {

    private FIFOCalculator calculator;

    @BeforeEach
    void init() {
        calculator = new FIFOCalculator();
    }

    @Test
    @DisplayName("입력 값이 null 이거나 공백 문자인 경우 예외 발생 테스트")
    void nullOrBlankInputTest() {
        calculator.setRawInput(null);

        // private 메소드를 reflection으로 호출하는 경우 예외가 InvocationTargetException으로 감싸져 있으므로 원래의 예외로 재발생시도한다.
        try {
            TestHelper.invokePrivateMethod(calculator, "validateInput");
        } catch (InvocationTargetException e) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> {
                        throw e.getTargetException();
                    });
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }

        calculator.setRawInput("");

        try {
            TestHelper.invokePrivateMethod(calculator, "validateInput");
        } catch (InvocationTargetException e) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> {
                        throw e.getTargetException();
                    });
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("입력 값이 허용되지 않은 기호를 포함하는 경우 예외 발생 테스트")
    void illegalInputStringTest() {
        calculator.setRawInput("1 & 1 + 1 = 1");

        try {
            TestHelper.invokePrivateMethod(calculator, "validateInput");
        } catch (InvocationTargetException e) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> {
                        throw e.getTargetException();
                    });
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("입력된 문자열을 토큰으로 나누는 메소드의 테스트")
    void tokenizeInputTest() {
        calculator.setRawInput("1 + 1 - 1 * 1 / 1");

        try {
            assertThat((String[])TestHelper.invokePrivateMethod(calculator, "tokenizeInput"))
                    .containsExactly("1", "+", "1", "-", "1", "*", "1", "/", "1");
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("입력된 문자열을 계산하는 테스트")
    void calculateTest() {
        calculator.setRawInput("1 + 1 - 1 * 1 / 1");

        assertThat(calculator.calculate()).isEqualTo(1);
    }
}
