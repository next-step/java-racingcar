package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("문자열이 주어졌을 때 split을 이용하면 숫자배열로 분리된다")
    public void 문자열이_주어졌을_때_split을_이용하면_숫자배열로_분리된다() {
        //given
        String given = "1,2";
        //when
        String[] results = given.split(",");
        //then
        assertThat(results).containsExactly("1", "2");
    }

    @Test
    @DisplayName("값이 주어졌을 때 substring으로 양끝을 제외후 추출하면 괄호가 제거된다")
    public void 값이_주어졌을_때_substring으로_양끝을_제외후_추출하면_괄호가_제거된다() {
        //given
        String given = "(1,2)";
        //when
        String result = given.substring(1, given.length() - 1);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 charAt의 범위를 벗어나면 StringIndexOutOfBoundsException 가 발생한다")
    public void abc_값이_주어졌을_때_charAt의_범위를_벗어나면_StringIndexOutOfBoundsException_가_발생한다(){
        //given
        String given = "abc";
        int idxOfOutOfRange = 10;
        //when
        //then
        assertThatThrownBy(() -> given.charAt(idxOfOutOfRange))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + idxOfOutOfRange);
    }
}
