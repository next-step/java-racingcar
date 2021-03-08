package study;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("[split] 쉼표 구분자가 없는 동작을 테스트합니다.")
    void splitWithoutCommaDelimiter() {
        //given
        String withoutDelimeterString = "1";

        //when
        String delimiter = ",";
        String[] splittedStringArray = withoutDelimeterString.split(delimiter);

        //then
        assertThat(splittedStringArray).containsExactly("1");
    }

    @Test
    @DisplayName("[split] 쉼표 구분자가 있는 동작을 테스트합니다.")
    void splitWithCommaDelimeter() {
        //given
        String withDelimeterString = "1,2";

        //when
        String delimiter = ",";
        String[] splittedStringArray = withDelimeterString.split(delimiter);

        //then
        assertThat(splittedStringArray).containsExactly("1", "2");
    }

    @Test
    @DisplayName("[substring] 괄호를 제외해보는 동작을 테스트합니다.")
    void substringExcludingParenthesis() {
        //given
        String wrappedParenthesisString = "(1,2)";
        int startInnerParenthesisIndex = 1;
        int endInnerParenthesisIndex = 4;

        //when
        String excludingParenthesisString = wrappedParenthesisString.substring(
                startInnerParenthesisIndex,
                endInnerParenthesisIndex
        );

        //then
        assertThat(excludingParenthesisString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("[charAt] 인덱스 범위를 넘지 않는 동작을 테스트합니다.")
    void charAtInbound() {
        //given
        String gluedPiecesString = "abc";

        //when
        char[] charPiecesArray = new char[]{
                gluedPiecesString.charAt(0),
                gluedPiecesString.charAt(1),
                gluedPiecesString.charAt(2)
        };

        //then
        assertThat(charPiecesArray).containsExactly('a', 'b', 'c');
    }

    @Test
    @DisplayName("[charAt] 인덱스 범위를 넘는 예외를 테스트합니다.")
    void charAtOutboundException() {
        //given
        String gluedPiecesString = "abc";

        //when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> gluedPiecesString.charAt(3);

        //then
        Class expectedExceptionClass = IndexOutOfBoundsException.class;
        assertThatThrownBy(throwingCallable).isInstanceOf(expectedExceptionClass);
    }
}
