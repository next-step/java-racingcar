package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Queue;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.Constants.SPLIT_DELIMITER;

/**
 * 사칙 연산 관련 데이터를 관리할 클래스 테스트
 */
class MathContextTest {

    private static Stream<Arguments> formulaStream() {
        return Stream.of(
            Arguments.of("2 + 1 * 3 / 2", 4, 3),
            Arguments.of("2 + 7 / 2 - 1", 4, 3),
            Arguments.of("2 + 1 / 3 * 2 + 1", 5, 4)
        );
    }

    private MathContext mathContext;

    @DisplayName("사칙연산 Context에 입력해서 Queue 생성되는지 확인")
    @ParameterizedTest(name = "{0} 연산 입력시 필드 null 체크 테스트")
    @MethodSource(value = "formulaStream")
    void setContext_ShouldFieldNotNull(String formula) {

        mathContext = new MathContext(formula);

        assertThat(mathContext).isNotNull();
        assertThat(mathContext.getNumbers()).isNotNull();
        assertThat(mathContext.getOperations()).isNotNull();
    }

    @DisplayName("공식 입력 후 숫자만 입력 테스트")
    @ParameterizedTest(name = "{0} 입력 시 숫자 갯수 {1} 개")
    @CsvSource(value = {"2 + 1 * 3 / 2, 4", "2 + 1 / 3 * 2 + 1, 5"})
    void setNumbers_ShouldReturnLinkedList(String formula, Integer numSize) {
        mathContext = new MathContext("");

        String[] splitFormula = formula.split(SPLIT_DELIMITER);
        Queue<Integer> numQueue = mathContext.setNumbers(splitFormula);

        assertThat(numQueue).isNotNull();
        assertThat(numQueue.size()).isEqualTo(numSize);
    }

    @DisplayName("공식 입력 후 ")
    @ParameterizedTest(name = "{0} 입력 시 연산자 개수 {1} 개")
    @CsvSource(value = {"2 + 1 / 3 * 2 + 1, 4"})
    void setOperations_ShouldReturnLinkedList(String formula, Integer operationSize) {
        mathContext = new MathContext("");

        String[] splitFormula = formula.split(SPLIT_DELIMITER);
        Queue<Operator> operatorQueue = mathContext.setOperations(splitFormula);

        assertThat(operatorQueue).isNotNull();
        assertThat(operatorQueue.size()).isEqualTo(operationSize);
    }

    @DisplayName("공식 입력 후 숫자, 연산자 갯수 체크")
    @ParameterizedTest(name = "{0} 공식 입력 후, 숫자 사이즈: {1}, 연산자 사이즈 {2}")
    @MethodSource(value = "formulaStream")
    void setContext_CheckNumbersAndOperationsSize(String formula, Integer numSize, Integer operationSize) {
        mathContext = new MathContext(formula);

        Queue<Integer> numbers = mathContext.getNumbers();
        Queue<Operator> operations = mathContext.getOperations();

        assertThat(numbers.size()).isEqualTo(numSize);
        assertThat(operations.size()).isEqualTo(operationSize);

    }
}
