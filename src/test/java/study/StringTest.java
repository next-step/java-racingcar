package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void splitTest() {
        // given
        String containComma = "1,2";
        String notContainComma = "1";

        // when
        String[] containCommaSplit = containComma.split(",");
        String[] notContainCommaSplit = notContainComma.split(",");

        // then
        assertThat(containCommaSplit).containsExactly("1", "2");
        assertThat(notContainCommaSplit).contains("1");
    }

    @Test
    void substringTest() {
        // given
        String originalStr = "(1,2)";

        // when
        String result = originalStr.substring(1, originalStr.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    void charAtTest() {
        // given
        String originalStr = "abc";
        char[] originalArr = originalStr.toCharArray();

        // when & then
        for (int i = 0; i < originalStr.length(); i++) {
            assertThat(originalStr.charAt(i)).isEqualTo(originalArr[i]);
        }

    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나는 경우 학습 테스트")
    void charAtTestWithStringIndexOut() {
        // given
        String originalStr = "abc";

        // when & then
        assertThatThrownBy(
                () -> originalStr.charAt(originalStr.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + originalStr.length());


    }
}
