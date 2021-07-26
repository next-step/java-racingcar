package step2.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @ParameterizedTest
    @DisplayName("isOperator() 메서드는 연산자 기호인 경우 true 를 리턴한다")
    @CsvSource({"+,true", "-,true", "*,true", "/,true, &,false, !,false"})
    void isOperator(String input, boolean expected) {
        boolean actual = Operator.isOperator(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Operator.findOperatorByString() 메서드는 연산 기호인 경우 Operator enum을 리턴한다")
    @MethodSource("findOperatorByStringParam")
    void findOperatorByString(String input, Operator expected) {
        Operator actual = Operator.findOperatorByString(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Operator.findOperatorByString() 메서드는 연산기호가 아닌 경우 IllegalArgumentException을 리턴한다")
    @MethodSource("findOperatorByStringWrongParam")
    void findOperatorByString_WrongInput(String input, Class<IllegalArgumentException> expected) {
        assertThrows(expected, () -> Operator.findOperatorByString(input));
    }

    @ParameterizedTest
    @DisplayName("Operator.ADDITION.calculate() 메서드는 덧셈을 수행한다")
    @CsvSource({"1,1,2", "2,3,5"})
    void ADDITION_calculate(int x, int y, int expected) {
        int calculated = Operator.ADDITION.calculate(x, y);
        assertEquals(expected, calculated);
    }

    @ParameterizedTest
    @DisplayName("Operator.SUBTRACTION.calculate() 메서드는 뺄셈을 수행한다")
    @CsvSource({"1,1,0", "2,3,-1"})
    void SUBTRACTION_calculate(int x, int y, int expected) {
        int calculated = Operator.SUBTRACTION.calculate(x, y);
        assertEquals(expected, calculated);
    }

    @ParameterizedTest
    @DisplayName("Operator.MULTIPLICATION.calculate() 메서드는 곱셈을 수행한다")
    @CsvSource({"1,1,1", "2,3,6"})
    void MULTIPLICATION_calculate(int x, int y, int expected) {
        int calculated = Operator.MULTIPLICATION.calculate(x, y);
        assertEquals(expected, calculated);
    }

    @ParameterizedTest
    @DisplayName("Operator.DIVISION.calculate() 메서드는 나눗셈을 수행한다")
    @CsvSource({"1,1,1", "2,3,0"})
    void DIVISION_calculate(int x, int y, int expected) {
        int calculated = Operator.DIVISION.calculate(x, y);
        assertEquals(expected, calculated);
    }

    private static Stream<Arguments> findOperatorByStringParam() {
        return Stream.of(
                Arguments.of("+", Operator.ADDITION),
                Arguments.of("-", Operator.SUBTRACTION),
                Arguments.of("*", Operator.MULTIPLICATION),
                Arguments.of("/", Operator.DIVISION)
        );
    }

    private static Stream<Arguments> findOperatorByStringWrongParam() {
        return Stream.of(
                Arguments.of("!", IllegalArgumentException.class),
                Arguments.of("@", IllegalArgumentException.class),
                Arguments.of("#", IllegalArgumentException.class),
                Arguments.of("$", IllegalArgumentException.class)
        );
    }
}