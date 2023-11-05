import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("콤마를 기준으로 나눌 수 있다")
    void split() {
        // given
        String given = "1,2";

        // when
        String[] result = given.split(",");

        // then
        assertThat(result).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    @DisplayName("괄호를 제거할 수 있다.")
    void substring() {
        // given
        String given = "(1,2)";

        // when
        String result = given.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 인덱스 범위를 넘어가면 예외가 발생한다.")
    void charAt_err() {
        // given
        String given = "abc";

        // when  // then
        assertThatThrownBy(() -> given.charAt(5))
                .isExactlyInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
