package StringCalculator.Enum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperationTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void find_happy(String input) {
        assertThat(Operation.find(input).getTitle()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "a", "가"})
    void find_blue(String input) {
        assertThatThrownBy(() -> Operation.find(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "3,4:7"}, delimiter = ':')
    void apply_add(String input, String expected) {
        Operation operation = Operation.ADD;
        String[] terms = input.split(",");
        int leftTerm = Integer.parseInt(terms[0]);
        int rightTerm = Integer.parseInt(terms[1]);
        assertThat(operation.apply(leftTerm, rightTerm))
                .isEqualTo(leftTerm + rightTerm);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "3,4:7"}, delimiter = ':')
    void apply_subtract(String input, String expected) {
        Operation operation = Operation.SUBTRACT;
        String[] terms = input.split(",");
        int leftTerm = Integer.parseInt(terms[0]);
        int rightTerm = Integer.parseInt(terms[1]);
        assertThat(operation.apply(leftTerm, rightTerm))
                .isEqualTo(leftTerm - rightTerm);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "3,4:7"}, delimiter = ':')
    void apply_multiply(String input, String expected) {
        Operation operation = Operation.MULTIPLY;
        String[] terms = input.split(",");
        int leftTerm = Integer.parseInt(terms[0]);
        int rightTerm = Integer.parseInt(terms[1]);
        assertThat(operation.apply(leftTerm, rightTerm))
                .isEqualTo(leftTerm * rightTerm);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "3,4:7"}, delimiter = ':')
    void apply_divide(String input, String expected) {
        Operation operation = Operation.DIVIDE;
        String[] terms = input.split(",");
        int leftTerm = Integer.parseInt(terms[0]);
        int rightTerm = Integer.parseInt(terms[1]);
        assertThat(operation.apply(leftTerm, rightTerm))
                .isEqualTo(leftTerm / rightTerm);
    }
}