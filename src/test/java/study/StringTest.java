package study;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

/**
 * @author : 김윤호
 * @version :
 * @date : 2019-10-24 21:20
 */
public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 3);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            "123".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
