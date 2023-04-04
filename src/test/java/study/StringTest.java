package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("split 메소드를 활용하여 배열에 값을 검증한다")
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
        assertThat("1".split(",")).contains("1");
    }

    @DisplayName("substring 메소드를 활용하여 1,2 값을 추출한다.")
    @Test
    void substring() {
        String data = "(1,2)";
        assertThat(data.substring(1, data.length() - 1)).isEqualTo("1,2");
    }

    @DisplayName("charAt 메소드 사용 시 인덱스를 벗어나면 StringIndexOutOfBoundsException 에러가 발생한다.")
    @Test
    void char_at() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        })
        .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("index out of range: 3");
    }
}
