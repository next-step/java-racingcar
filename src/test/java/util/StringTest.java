package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("하나의 문자열을 구분자(,)로 자르는 테스트")
    public void split() {
        // given
        String firstCase = "1,2";
        String secondCase = "1";

        // when
        String[] expectedFirstCase = firstCase.split(",");
        String[] expectedSecondCase = secondCase.split(",");

        // then
        Assertions.assertAll(
                () -> assertThat(expectedFirstCase).contains("1", "2"),
                () -> assertThat(expectedSecondCase).containsExactly("1")
        );
    }

    @Test
    @DisplayName("하나의 문자열을 파싱하는 테스트")
    public void parse() {
        // given
        String firstCase = "(1,2)";

        // when
        String expected = StringUtil.parse(firstCase);

        // then
        assertThat(expected).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 특정 위치의 문자 한 개를 가져오는 테스트")
    public void charOf() {
        String firstCase = "abc";

        // nominal
        char expected = firstCase.charAt(0);
        assertThat(expected).isEqualTo('a');

        // abnormal
        Assertions.assertAll(
                () ->
                        assertThatThrownBy(() -> firstCase.charAt(-1)).isInstanceOf(IndexOutOfBoundsException.class)
                                .hasMessageContaining("out of range: -1"),
                () ->
                        assertThatThrownBy(() -> firstCase.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class)
                                .hasMessageContaining("out of range: 4")
        );
    }
}
