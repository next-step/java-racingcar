package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @Test
    @DisplayName("두 요소의 split이 잘 동작하는 지 확인한다.")
    void split_two_char() {
        String string = "1,2";
        String delimiter = ",";

        assertThat(string.split(delimiter)).contains("1");
        assertThat(string.split(delimiter)).contains("2");
        assertThat(string.split(delimiter)).containsExactly("1", "2");
    }

    @Test
    @DisplayName("한 요소의 split이 잘 동작하는 지 확인한다.")
    void split_one_char() {
        String string = "1";
        String delimiter = ",";

        assertThat(string.split(delimiter)).containsExactly("1");
    }
}
