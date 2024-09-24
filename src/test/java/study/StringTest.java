package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    @DisplayName("문자열 split 테스트")
    void split() {
        String []splitResult = "1,2".split(",");

        String []oneResult = "1".split(",");

        assertThat(oneResult).containsExactly("1");
        assertThat(splitResult).containsExactly("1", "2");
    }


    @Test
    @DisplayName("문자열 substring 테스트")
    void substring(){
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");

    }

    @Test
    @DisplayName("문자열 chatAt 성공 테스트")
    void chatAt_success() {
        char zeroIndex = "abc".charAt(0);
        char oneIndex = "abc".charAt(1);
        char twoIndex = "abc".charAt(2);

        assertAll(
                ()-> assertEquals(zeroIndex, 'a'),
                () -> assertEquals(oneIndex, 'b'),
                () -> assertEquals(twoIndex, 'c')
        );
    }

    @Test
    @DisplayName("문자열 chatAt 실패 테스트")
    void charAt_fail(){

        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(IndexOutOfBoundsException.class).hasMessageMatching("String index out of range: \\d+");

    }


}
