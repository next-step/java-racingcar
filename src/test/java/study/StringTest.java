package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 자동차 경주
 * 1단계 - 학습 테스트
 * String 클래스
 */
public class StringTest {

    @DisplayName(value = "[요구사항 1] : 구분자 ','로 배열을 반환한다.")
    @Test
    void split() {
        // given
        String source = "1,2";

        // when
        String[] result = source.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName(value = "[요구사항 2] : ()를 제외한 문자만 가져온다.")
    @Test
    void substring() {
        // given
        String source = "(1,2)";

        // when
        String result = source.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName(value = "[요구사항 3] : 특정 위치의 문자열을 가져온다.")
    @Test
    void charAt() {
        // given
        String source = "abc";

        // when
        char result = source.charAt(0);

        //then
        assertThat(result).isEqualTo('a');
    }

    @DisplayName(value = "[요구사항 3] : charAt()메서드 활용 시 값을 벗어나면 IndexOutOfBoundsException 발생.")
    @Test
    void indexOutOfBoundsException() {
        // given
        String source = "abc";

        // when
        assertThatThrownBy(() -> {
            source.charAt(5);
        // then
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
