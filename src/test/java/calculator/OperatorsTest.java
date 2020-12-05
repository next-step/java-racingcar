package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorsTest {
    private static final String WRONG_INPUT = "입력값이 잘못되었습니다.";
    private static final String BLANK = " ";

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3, 1, +","4 * 2 / 1, 0, *","3 * 5 - 9 + 2, 2, +"})
    @DisplayName("순번에 맞는 연산자를 반환하는지 테스트")
    public void operatorCheck(String input, int index, String expected){
        //when
        Operators formula = new Operators(input.split(BLANK));

        //then
        assertThat(formula.get(index).getOperator()).isEqualTo(expected);
    }
}
