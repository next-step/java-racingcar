package study;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void splitTest1() throws Exception {
        //given
        String inputString = "1,2";
        String regex = ",";

        //when
        String[] splitResults = inputString.split(regex);

        //then
        assertThat(splitResults).containsExactly("1", "2");
    }

    @Test
    void splitTest2() throws Exception {
        //given
        String inputString = "1";
        String regex = ",";

        //when
        String[] splitResults = inputString.split(regex);

        //then
        assertThat(splitResults).containsExactly("1");
    }

    @Test
    void subStringTest() throws Exception {
        //given
        String inputString = "(1,2)";
        int bodyStartIdx = 1;
        int bodyEndIdx = inputString.length() - 1;

        //when
        String subStringResult = inputString.substring(bodyStartIdx, bodyEndIdx);

        //then
        assertThat(subStringResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName("0보다 작은 인덱스에 해당하는 문자를 가져오면 예외를 던진다.")
    void charAtTest1() throws Exception {
        //given
        String inputString = "abc";
        int targetIdx = -1;

        //when
        ThrowingCallable charAtCallable = () -> inputString.charAt(targetIdx);

        //then
        verifyThrowOutOfIndexException(charAtCallable, targetIdx);
    }

    @Test
    @DisplayName("문자열 길이 이상의 인덱스에 해당하는 문자를 가져오면 예외를 던진다.")
    void charAtTest2() throws Exception {
        //given
        String inputString = "abc";
        int targetIdx = inputString.length();

        //when
        ThrowingCallable charAtCallable = () -> inputString.charAt(targetIdx);

        //then
        verifyThrowOutOfIndexException(charAtCallable, targetIdx);
    }

    private void verifyThrowOutOfIndexException(ThrowingCallable charAtCallable, int targetIdx) {
        assertThatThrownBy(charAtCallable)
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: " + targetIdx);
    }
}
