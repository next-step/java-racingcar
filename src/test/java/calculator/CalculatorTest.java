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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;
    private Validator validator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        validator = new Validator();
    }

    @Test
    @DisplayName("덧셈")
    void addTest() {
        String[] data = {"4","+","2"};
        assertEquals(6,calculator.calculate(data));
    }

    @Test
    @DisplayName("뺄셈")
    void minusTest() {
        String[] data = {"4","-","2"};
        assertEquals(2,calculator.calculate(data));
    }

    @Test
    @DisplayName("곱셈")
    void multipleTest() {
        String[] data = {"4","*","2"};
        assertEquals(8,calculator.calculate(data));
    }

    @Test
    @DisplayName("나눗셈")
    void divideTest() {
        String[] data = {"4","/","2"};
        assertEquals(2,calculator.calculate(data));
    }

    @ParameterizedTest
    @CsvSource({"4+2-3,true","4-2+3,true","4*2+3,true","4#2,false","4+3#2,false"})
    @DisplayName("사칙연산을 모두 포함해서 확인")
    void numberAndOperationTest(String input,String expected){
        String[] splitData = input.split("");
        assertEquals(expected,validator.isNumberAndOperation(splitData));
    }

    static Stream<String> blankStrings() {
        return Stream.of(""," ",null);
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    @DisplayName("입력값이 null이거나 빈 공백 문자열인 경우 확인")
    void isBlankTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            validator.isBlank(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings={"+","-","/","*","&","#"})
    @DisplayName("사칙연산 기호가 아닌 경우 확인")
    void isNotOperationTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            validator.isNotOperation(input);
        });
    }


}
