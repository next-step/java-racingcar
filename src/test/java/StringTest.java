import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    public void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");
        assertThat(values).containsExactly("1", "2"); // 순서까지 보장
    }

    @Test
    public void charAt() {
        // 예외 처리 검증
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
