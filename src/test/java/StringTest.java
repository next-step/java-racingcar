import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void split테스트() {
        // given
        String firstCase = "1,2";
        String secondCase = "1";

        // when
        String[] expectedFirstCase = firstCase.split(",");
        String[] expectedSecondCase = secondCase.split(",");

        // then
        assertThat(expectedFirstCase).contains("1", "2");
        assertThat(expectedSecondCase).containsExactly("1");
    }

    @Test
    public void parsing테스트() {
        // given
        String firstCase = "(1,2)";

        // when
        String expected = StringUtil.parse(firstCase);

        // then
        assertThat(expected).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 특정 위치의 문자 가져오는 테스트")
    public void charOf() {
        String firstCase = "abc";

        // nominal
        char expected = firstCase.charAt(0);
        assertThat(expected).isEqualTo('a');

        // abnormal
        assertThatThrownBy(() -> {
            firstCase.charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: -1");

        assertThatThrownBy(() -> {
           firstCase.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: 4");
    }
}
