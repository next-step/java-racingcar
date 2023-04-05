import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split의 사용법을 실습한다")
    void split() {
        String[] split1 = "1,2".split(",");
        assertThat(split1).containsExactly("1","2");

        String[] split2 = "1".split(",");
        assertThat(split2).containsExactly("1");
    }

    @Test
    @DisplayName("substring의 사용법을 실습한다")
    void substring() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("배열 인덱스를 넘는 char를 참조한다는 Exception이 발생하는지 확인한다")
    void charAt() {
        assertThatThrownBy(() -> { "abc".charAt(6); }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
