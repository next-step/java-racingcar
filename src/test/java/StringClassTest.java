import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringClassTest {

    private static final String LPAREN = "(";
    private static final String RPAREN = ")";
    private static final String COMMA = ",";
    private static final String STRING_ONE = "1";
    private static final String STRING_TWO = "2";
    private static final String LENGTH_3_ALPHABET_SEQUENCE = "abc";

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

    @DisplayName("길이가 3인 문자열 abc 의 첫 번째 문자는 a이다")
    @Test
    void 길이가_3인_문자열_abc_의_첫_번째_문자는_a_이다() {
        //given
        //when
        char firstCharacter = LENGTH_3_ALPHABET_SEQUENCE.charAt(0);
        //then
        assertThat(firstCharacter).isEqualTo('a');
    }

    @DisplayName("길이가 3인 문자열 abc 의 네 번째 문자를 가져오면 StringIndexOutOfBoundsException이 발생한다")
    @Test
    void 길이가_3인_문자열_abc_의_네_번째_문자를_가져오면_StringIndexOutOfBoundsException이_발생한다() {
        //given
        //when & then
        Assertions.assertThatThrownBy(() -> {
            LENGTH_3_ALPHABET_SEQUENCE.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
