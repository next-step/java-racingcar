package requirement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void isContain_ShouldContainsExpectedSplitStringArray() {
        String[] expectedValue = {"1", "2"};

        assertThat(StringHelper.splitter("1,2")).containsExactly(expectedValue);
    }

    @Test
    public void isContain_ShouldContainsExpectedSplitHasParenthesesStringArray() {
        String[] expectedValue = {"1", "2"};

        assertThat(StringHelper.splitter("(1,2)")).containsExactly(expectedValue);
    }

    @Test
    public void isEquals_ShouldEqualExpectedValue() {
        char expectedValue = 'a';

        assertThat(StringHelper.getCharByIndex("abc", 0)).isEqualTo(expectedValue);

        assertThatThrownBy(() -> {
            assertThat(StringHelper.getCharByIndex("abc", 4)).isEqualTo(expectedValue);
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("4");
    }
}
