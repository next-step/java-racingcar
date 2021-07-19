import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split_배열에_1과_2가_존재하는가() {
        String result[] = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_배열에_1이_존재하는가() {
        final String one = "1";
        String result[] = one.split(",");
        assertThat(result).containsExactly(one);
    }

    @Test
    void substring_기능_테스트() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 문자를 charAt()으로 특정 위치 문자 가져오는 테스트")
    void charAt_기능_테스트() {
        char ch = "abc".charAt(2);
        assertThat(ch).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() 범위 초과되어 StringIndexOutOfBoundsException 발생")
    void charAt_범위_초과_StringIndexOutOfBoundsException_발생_확인() {
        final int index = 4;
        final String word = "abc";
        assertThatThrownBy(() -> word.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d", index));
    }
}
