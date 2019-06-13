import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split1() {
        // given
        String str = "1,2";

        // when
        String[] result = str.split(",");

        // then
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
    }

    @Test
    void split2() {
        // given
        String str = "1";

        // when
        String[] result = str.split(",");

        // then
        assertThat(result[0]).isEqualTo("1");
        assertThat(result.length).isEqualTo(1);
    }

    @Test
    void substring() {
        // given
        String str = "(1,2)";

        // when
        String result = str.substring(1,4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        // given
        String str = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                // when
                .isThrownBy(() -> {
                    str.charAt(str.length()+1);
                // then
                }).withMessageMatching("String index out of range: \\d+");
    }
}
