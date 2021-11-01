import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringClassTest {

    private static final String LPAREN = "(";
    private static final String RPAREN = ")";
    private static final String COMMA = ",";
    private static final String STRING_ONE = "1";
    private static final String STRING_TWO = "2";

    @Test
    void 문자열_1_콤마_2를_콤마로_split_하면_1과_2를_포함한다() {
        //given
        String numbers = STRING_ONE + COMMA + STRING_TWO;
        //when
        String[] splitNumbers = numbers.split(COMMA);
        //then
        assertThat(splitNumbers).contains(STRING_ONE, STRING_TWO);
    }

    @Test
    void 문자열_1_을_콤마로_split_하면_1만을_포함한다() {
        //given
        //when
        String[] splitNumbers = STRING_ONE.split(COMMA);
        //then
        assertThat(splitNumbers).containsExactly(STRING_ONE);
    }

    @Test
    void 문자열_왼쪽_괄호_1_콤마_2_오른쪽_괄호를_subString_사용하여_문자열_1_콤마_2로_만든다() {
        //given
        String numbers = STRING_ONE + COMMA + STRING_TWO;
        String numberPair = LPAREN + numbers + RPAREN;
        //when
        String subStringNumbers = numberPair.substring(1, numberPair.length() - 1);
        //then
        assertThat(subStringNumbers).isEqualTo(numbers);
    }

}
