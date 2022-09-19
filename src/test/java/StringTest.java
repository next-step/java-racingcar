import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("문자열을 자르면 배열로 반환된다.")
    void split_return_array(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("문자열을 잘라 반환된 배열을 순서를 보장한다.")
    void split_return_ordered_array(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }
}
