package study;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("[1. 문자열 분리] : 1,2")
    public void split1() {
        // given
        String one = "1";
        String two = "2";
        String delimiter = ",";
        String input = String.join(delimiter, one, two);
        String[] expected = {one, two};

        // when
        String[] split = input.split(delimiter);

        // then
        assertThat(split)
                .contains(one)
                .contains(two)
                .containsExactly(one, two)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("[1. 문자열 분리] : 1,")
    public void split2() {
        // given
        String one = "1";
        String delimiter = ",";
        String input = String.join(delimiter, one);
        String[] expected = {one};

        // when
        String[] split = input.split(delimiter);

        // then
        assertThat(split)
                .contains(one)
                .containsExactly(one)
                .isEqualTo(expected);
    }

    
    @Test
    @DisplayName("[2. 괄호 제거] : (1,2)")
    public void peelBracket1() {
        // given
        String input = "(1,2)";
        String expected = "1,2";
        
        // when
        String peeled = peelBracket(input);
        
        // then
        assertThat(peeled).isEqualTo(expected);
    }

    @Test
    @DisplayName("[2. 괄호 제거] : 1,2")
    public void peelBracket2() {
        // given
        String input = "1,2";
        String expected = "1,2";

        // when
        String peeled = peelBracket(input);

        // then
        assertThat(peeled).isEqualTo(expected);
    }

    public String peelBracket(String text) {
        return isWrappedInBracket(text)
                ? text.substring(1, text.length() - 1)
                : text;
    }

    public boolean isWrappedInBracket(String text) {
        return text.startsWith("(") && text.endsWith(")");
    }

    @ParameterizedTest(name = "[3. charAt 예외] : {arguments}")
    @ValueSource(ints = {-1, 3})
    public void charAtException(int index) {
        // given
        String input = "input";
        String message = "String index out of range: " + index;

        // when
        ThrowingCallable throwingCallable = () -> input.charAt(index);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage(message);
    }

}
