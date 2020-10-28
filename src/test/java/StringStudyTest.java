import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringStudyTest {

    @Test
    public void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    public void substring() {
        String input = "(1,2)";
        assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0, a", "1, b", "2, c"})
    public void charAt_normalCases(int index, char expected) {
        String abc = "abc";
        assertThat(abc.charAt(index)).isEqualTo(expected);
    }

    @Test
    @DisplayName("String.charAt 에서 발생하는 Exception 에 대해 학습한다")
    public void charAt_throwingExceptions() {
        String abc = "abc";
        assertThatThrownBy(() -> abc.charAt(99))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
