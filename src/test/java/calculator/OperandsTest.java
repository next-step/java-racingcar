package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandsTest {

    @DisplayName("올바른 피연산자들을 생성하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "24,324"})
    void createTest(String input) {
        String[] splitInput = input.split(",");
        Operands operands = new Operands(Arrays.asList(splitInput));

        assertThat(operands).isNotNull();
        assertThat(operands.size()).isEqualTo(splitInput.length);
        for (int i = 0; i < splitInput.length; i++) {
            int expected = Integer.parseInt(splitInput[i]);
            assertThat(operands.get(i)).isEqualTo(expected);
        }
    }
}
