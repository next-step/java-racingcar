package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("요구사항1: split")
    void req1() {
        // given
        String[] result = "1,2".split(",");

        // then
        assertThat( result ).contains("1");
        assertThat( result ).containsExactly("1", "2" );
    }

    @Test
    @DisplayName("요구사항2: substring")
    void req2() {
        // given
        String str = "(1,2)";

        // when
        String result = str.substring( 1, 4);

        // then
        assertThat( result ).isEqualTo("1,2");
    }

    @DisplayName("요구사항3: chatAt 특정 위치의 문자를 가져오는 학습 테스트")
    @Test
    void req3() {
        // given
        String str = "abc";
        int bigIndex = str.length() + 999;

        assertThatThrownBy( () -> {
            // when
            str.charAt(bigIndex);
        })  // then
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + (bigIndex));
    }
}
