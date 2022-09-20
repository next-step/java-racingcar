package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {


    @Test
    @DisplayName("여러 숫자 사이에 ,가 있는 문자열을 , split 했을 때 숫자들만 포함한 숫자만 반환된다.")
    void twoNumberWithCommaSplitTest() {
        // given
        String sut = "1,2";

        // when
        String[] result = sut.split(",");

        // then
        Assertions.assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("단일 숫자 + , 조합의 문자열을 , split 했을 때 하나의 숫자만 반환된다.")
    void singleNumberWithCommaSplitTest() {
        // given
        String sut = "1,";

        // when
        String[] result = sut.split(",");

        // then
        Assertions.assertThat(result).contains("1");
        Assertions.assertThat(result).doesNotContain("2");
    }

    @Test
    @DisplayName("소괄호로 내부에 있는 문자열을 추출한다.")
    void substringTest() {
        // given
        String sut = "(1,2)";

        // when
        String result = sut.substring(1, sut.length() - 1);

        // then
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 내부 index에 접근하여 해당하는 값을 가져온다.")
    void charAtTest() {
        // given
        String sut = "abc";

        // when & then
        org.junit.jupiter.api.Assertions.assertAll(
            () -> Assertions.assertThat(sut.charAt(0)).isEqualTo('a'),
            () -> Assertions.assertThat(sut.charAt(1)).isEqualTo('b'),
            () -> Assertions.assertThat(sut.charAt(2)).isEqualTo('c')
        );
    }

    @Test
    @DisplayName("문자열의 index 외부 참조 시 StringIndexOutOfBoundsException 예외 발생.")
    void charAtStringIndexOutOfBoundsException() {
        // given
        String sut = "abc";

        // when & then
        Assertions.assertThatThrownBy(() -> {
            sut.charAt(sut.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
