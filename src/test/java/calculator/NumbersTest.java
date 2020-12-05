package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumbersTest {
    private static final String WRONG_INPUT = "입력값이 잘못되었습니다.";
    private static final String BLANK = " ";

    @Test
    @DisplayName("입력값이 null일 경우 IllegalArgumentException throw")
    public void nullCheck(){
        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Numbers(null))
                .withMessageMatching(WRONG_INPUT);
    }

    @Test
    @DisplayName("입력값이 빈 공백 문자일 경우 IllegalArgumentException throw")
    public void blankCheck(){
        //given
        String blank = " ";

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Numbers(blank.split(BLANK)))
                .withMessageMatching(WRONG_INPUT);
    }

    @Test
    @DisplayName("숫자(정수)로 변환 불가능한 값의 경우 IllegalArgumentException throw")
    public void symbolCheck(){
        //given
        String notOperator = "1 + 2 * #";

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Numbers(notOperator.split(BLANK)))
                .withMessageMatching(WRONG_INPUT);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3, 1, 2","4 * 2 / 1, 1, 2","3 * 5 - 9 + 2, 3, 2"})
    @DisplayName("순번에 맞는 숫자를 반환하는지 테스트")
    public void numberCheck(String input, int index, int expected){
        //when
        Numbers formula = new Numbers(input.split(BLANK));

        //then
        assertThat(formula.get(index)).isEqualTo(expected);
    }
}
