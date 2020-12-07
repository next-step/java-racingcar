package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorsTest {

    @DisplayName("문자열로 올바른 연산자들을 생성하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+,-,/,*", "-,+,*,*"})
    void createTest(String input) {
        String[] splitInput = input.split(",");
        Operators operators = new Operators(Arrays.asList(splitInput));

        assertThat(operators).isNotNull();
        assertThat(operators.size()).isEqualTo(splitInput.length);
        for (int i = 0; i < splitInput.length; i++) {
            Operator expected = Operator.of(splitInput[i]);
            assertThat(operators.get(i)).isEqualTo(expected);
        }
    }
}
