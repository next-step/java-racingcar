package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class calcTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("input split test")
    void splitStr() {
        String testStr = "2 + 3 * 4 / 2";
        String[] splitStr = calculator.splitStr(testStr);
        assertThat(splitStr).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }


    @DisplayName("Valid input String is Blank or Null exception case")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validBlankOrNull(String strInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.validBlankOrNull(strInput);
        });
    }

    @ParameterizedTest
    @DisplayName("Valid input String is Blank or Null not exception case")
    @ValueSource(strings = {"2 + 3 * 4 / 2", "123"})
    void validNotBlankOrNullStr(String strInput) {
        assertThatCode(() -> calculator.validBlankOrNull(strInput)).doesNotThrowAnyException();
    }


    @DisplayName("Valid input operation not exception case")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void isOperation(String inputOperation) {
        assertThatCode(() -> Operation.validate(inputOperation)).doesNotThrowAnyException();
    }

    @DisplayName("Valid input operation exception case")
    @ParameterizedTest
    @ValueSource(strings = {"&", "1", "^", "%"})
    void isNotOperation(String inputOperation) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operation.validate(inputOperation);
        });
    }

    @DisplayName("Valid input String has correct operation")
    @Test
    void validOperation() {
        String[] arrInput = {"+", "*", "-", "/"};
        assertThatCode(() -> calculator.validAllOperation(arrInput)).doesNotThrowAnyException();

    }

    @DisplayName("Valid input String has not correct operation")
    @Test
    void validNotOperation() {
        String[] arrInput = {"&", "^", "1", "%"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.validAllOperation(arrInput);
        });
    }


    @Test
    @DisplayName("test plus")
    void plus() {
        Integer input1 = 3;
        Integer input2 = 5;
        Integer expectResult = 8;
        Integer result = Operation.plus(input1, input2);

        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("test minus")
    void minus() {
        Integer input1 = 4;
        Integer input2 = 3;
        Integer expectResult = 1;
        Integer result = Operation.minus(input1, input2);

        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("test multiple")
    void multiple() {
        Integer input1 = 3;
        Integer input2 = 5;
        Integer expectResult = 15;
        Integer result = Operation.multiple(input1, input2);

        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("test division")
    void division() {
        Integer input1 = 4;
        Integer input2 = 2;
        Integer expectResult = 2;
        Integer result = Operation.division(input1, input2);

        assertThat(result).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource({"+,6", "-,2", "*,8", "/,2"})
    @DisplayName("operator Test")
    void operator(String inputOperation, Integer expectResult) {
        Integer inputNum1 = 4;
        Integer inputNum2 = 2;

        Integer result = Operation.operator(inputNum1, inputNum2, inputOperation);

        assertThat(result).isEqualTo(expectResult);
    }


    @ParameterizedTest
    @CsvSource({"\"2 + 3 * 4 / 2\",\"10\"", "\"1 + 5 * 4 / 3\",\"8\""})
    @DisplayName("calculate Test")
    void calculate(String strInput, String expectResult) {
        String result = calculator.calculate(strInput);
        assertThat(result).isEqualTo(expectResult);
    }


    @Test
    @DisplayName("get number from String arrays")
    void getNumbers() {
        String[] arrInput = {"2", "+", "3", "*", "4", "-", "5", "/", "6"};
        Integer[] expectResult = {2, 3, 4, 5, 6};

        Integer[] result = calculator.getNumbers(arrInput);

        assertThat(result).containsExactly(expectResult);
    }

    @Test
    @DisplayName("get operation from String arrays")
    void getOperations() {
        String[] arrInput = {"2", "+", "3", "*", "4", "-", "5", "/", "6"};
        String[] expectResult = {"+", "*", "-", "/"};

        String[] result = calculator.getOperations(arrInput);

        assertThat(result).containsExactly(expectResult);
    }


}
