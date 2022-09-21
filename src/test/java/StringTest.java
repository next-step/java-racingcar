import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("'1,2'을_,로_split_하면_1과_2로_분리된다")
    void split() {
        String value = "1,2";
        String[] result = value.split(",");

        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("'1'을_,로_split_했을_때_1만_포함한다")
    void splitSingleValue() {
        String value = "1";
        String[] result = value.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("'substring은_원하는_위치의_문자열만을_잘라준다")
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }
    @Test
    @DisplayName("대상_문자열의_위치_값을_벗어난_인덱스로_charAt_메소드를_호출하면_StringIndexOutOfBoundsException이_발생한다")
    void charAt() {
        String value = "01234";

        assertThatThrownBy(() -> {value.charAt(5);})
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
