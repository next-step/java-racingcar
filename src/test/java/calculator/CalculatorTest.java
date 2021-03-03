package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        validator = new Validator();
    }

    @Test
    @DisplayName("덧셈")
    public void addTest() {
        String[] data = {"4","+","2"};
        assertEquals(6,calculator.calculate(data));
    }

    @Test
    @DisplayName("뺄셈")
    public void minusTest() {
        String[] data = {"4","-","2"};
        assertEquals(2,calculator.calculate(data));
    }

    @Test
    @DisplayName("곱셈")
    public void multipleTest() {
        String[] data = {"4","*","2"};
        assertEquals(8,calculator.calculate(data));
    }

    @Test
    @DisplayName("나눗셈")
    public void divideTest() {
        String[] data = {"4","/","2"};
        assertEquals(2,calculator.calculate(data));
    }

    static Stream<String> blankStrings() {
        return Stream.of(""," ",null);
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    @DisplayName("입력값이 null이거나 빈 공백 문자열인 경우")
    void isBlank(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            validator.isBlank(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings={"+","-","/","*","&","#"})
    @DisplayName("사칙연산 기호가 아닌 경우")
    void checkNull(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            validator.isNotOperation(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
