package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputParserTest {

    private Operator operator;

    @BeforeEach
    void setUp() {
        this.operator = new Operator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 + 4 * 2", "3 - 1 * 4"})
    @DisplayName("일반적인 상황에서의 테스트")
    void onHappyPath(String input) {
        String[] expected = input.split(" ");
        InputParser inputParser = InputParser.of(input, this.operator);
        String[] result = inputParser.parseInput();

        assertThat(result).isEqualTo(expected);

    }

    @ParameterizedTest
    @ValueSource(strings = {"3 + 4 -", "5 * 2 -"})
    @DisplayName("짝이 맞지 않는 식의 테스트")
    void unpairTest(String input) {
        InputParser inputParser = InputParser.of(input, this.operator);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> {
                    inputParser.parseInput();
                }
        );

    }

    @DisplayName("올바르지 않은 연산자를 포함한 입력에 대한 테스트")
    @ValueSource(strings = {"1 & 3 * 2", "1 % 3 * 4"})
    @ParameterizedTest
    void containInvalidOperator(String input) {
        InputParser inputParser = InputParser.of(input, this.operator);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(
                        () -> {
                            inputParser.parseInput();
                        }
                );
    }

}
