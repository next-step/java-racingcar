package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringStudy {

    @DisplayName("콤마 split 테스트")
    @Test
    public void contains() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @DisplayName("콤마 split 특정값만 포함하는지 테스트")
    @Test
    public void containsExactly() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("substring 학습 테스트")
    @Test
    public void substring() {
        String str = "(1,2)";
        String actual = str.substring(1, str.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("charAt 학습 테스트")
    @ParameterizedTest
    @CsvSource({"0,a", "1,b", "2,c"})
    public void charAt(int index, char ch) {
        String str = "abc";
        assertThat(str.charAt(index)).isEqualTo(ch);
    }

    @DisplayName("charAt 범위 벗어나면 StringIndexOutOfBoundsException")
    @ParameterizedTest
    @CsvSource({"-1", "3"})
    public void charAtException(int index) {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
