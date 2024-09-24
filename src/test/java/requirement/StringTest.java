package requirement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest  {
    StringHelper stringHelper = new StringHelper();

    @Test
    public void isContain_ShouldContainsExpectedSplitStringArray() {
        String[] expectedValue1 = {"1", "2"};

        assertThat(expectedValue1).containsExactly(stringHelper.splitter("1,2"));

        String[] expectedValue2 = {"1"};

        assertThat(expectedValue2).containsExactly(stringHelper.splitter("1"));
    }

    @Test
    public void isContain_ShouldContainsExpectedSplitHasParenthesesStringArray() {
        String[] expectedValue1 = {"1", "2"};

        assertThat(expectedValue1).containsExactly(stringHelper.splitter("(1,2)"));
    }

    @Test
    public void isEquals_ShouldEqualExpectedValue() {
        char expectedValue1 = 'a';

        assertThat(expectedValue1).isEqualTo(stringHelper.getCharByIndex("abc", 0));

        assertThatThrownBy(() -> {
            assertThat(expectedValue1).isEqualTo(stringHelper.getCharByIndex("abc", 4));
        }).isInstanceOf(Exception.class)
                    .hasMessageContaining("4");
    }
}
