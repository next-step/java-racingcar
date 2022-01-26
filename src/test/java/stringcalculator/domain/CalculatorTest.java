package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.common.UserInput;

class CalculatorTest {

    private UserInput userInput;

    @DisplayName("객체 초기화")
    @BeforeEach
    void name() {
        userInput = new UserInput();
    }

    @DisplayName("계산기 수행 검증")
    @Test
    void operatorTest() {
        List<String> userInput = new ArrayList<>((Arrays.asList("1", "+", "2", "-", "1")));
        Calculator calculator = Calculator.of(userInput);
        int result = calculator.process();
        Assertions.assertThat(result).isEqualTo(2);
    }

    @DisplayName("공백 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void blankTest(String input) {
        userInput.setUserInput(input);
        assertTrue(userInput.parsingUserInput());
    }

    @DisplayName("null 테스트")
    @ParameterizedTest
    @NullSource
    void nullTest(String input) {
        userInput.setUserInput(input);
        assertTrue(userInput.parsingUserInput());
    }

    @DisplayName("empty 테스트")
    @ParameterizedTest
    @EmptySource
    void emptyTest(String input) {
        userInput.setUserInput(input);
        assertTrue(userInput.parsingUserInput());
    }

    @DisplayName("null과 empty 그리고 공백, \t, \n 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void nullAndEmptyTest(String input) {
        userInput.setUserInput(input);
        assertTrue(userInput.parsingUserInput());
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @EnumSource(Operator.class)
    public void addTest(Operator operator) {
        int result = Operator.of("+").operate(1, 5);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @EnumSource(Operator.class)
    public void subTest(Operator operator) {
        int result = Operator.of("-").operate(9, 6);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("곱하기 테스트")
    @ParameterizedTest
    @EnumSource(Operator.class)
    public void multipleTest(Operator operator) {
        int result = Operator.of("*").operate(9, 6);
        assertThat(result).isEqualTo(54);
    }

    @DisplayName("나누기 테스트")
    @ParameterizedTest
    @EnumSource(Operator.class)
    public void divideTest(Operator operator) {
        int result = Operator.of("/").operate(9, 6);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("0으로 나누었을 때 Valid 테스트")
    @ParameterizedTest
    @EnumSource(Operator.class)
    public void divideValidTest(Operator operator) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Operator.of("/").operate(9, 0));
    }

}