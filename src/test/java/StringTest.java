import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @DisplayName("1,2 를 , 로 split 하면 1과 2가 반환된다")
    @Test
    public void test() {
        String str = "1,2";

        String[] result = str.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("1을 , 로 split 하면 1이 반환된다")
    @Test
    public void test2() {
        String str = "1";

        String[] result = str.split(",");

        assertThat(result).containsExactly("1");
    }
}
