import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {
    private final String ASSERTJ_CONTAINS_TEST = "1,2";
    private final String ASSERTJ_CONTAINS_EXACTLY_TEST = "1,";
    private final String COMMA = ",";
    private final String SUBSTRING_TEST = "(1,2)";
    private final String CHARAT_TEST = "abc";

    @Test
    void assertJContains() {
        assertThat(ASSERTJ_CONTAINS_TEST.split(COMMA)).contains("1");
        assertThat(ASSERTJ_CONTAINS_TEST.split(COMMA)).contains("2");
        assertThat(ASSERTJ_CONTAINS_TEST.split(COMMA)).doesNotContain("3");
    }

    @Test
    void assertJContainsExactly() {
        assertThat(ASSERTJ_CONTAINS_EXACTLY_TEST.split(COMMA)).containsExactly("1");
    }

    @Test
    void substring() {
        int lparenIndex = SUBSTRING_TEST.indexOf('(');
        int rparenIndex = SUBSTRING_TEST.indexOf(')');
        assertThat(SUBSTRING_TEST.substring(lparenIndex+1, rparenIndex)).isEqualTo(ASSERTJ_CONTAINS_TEST);
    }

    @DisplayName("특정 위치의 문자를 반환한다. 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생한다.")
    @Test
    void chatAt() {
        int outOfBoundIndex = 4;

        assertThat(CHARAT_TEST.charAt(1)).isEqualTo('b');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    CHARAT_TEST.charAt(outOfBoundIndex);
                }).withMessage("String index out of range: %d", outOfBoundIndex);
    }
}
