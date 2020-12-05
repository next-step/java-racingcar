package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 \",\"로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 \",\"로 split 했을 때 1만을 포함하는 배열이 반환되는지")
    void splitOneParts() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @ParameterizedTest
    @DisplayName("\"(1,2)\"값이 주어졌을 때 String의 substring() 메소드를 활용해 \"()\"을 제거하고 \"1,2\" 반환")
    @ValueSource(strings = {"(1,2)"})
    void substring(String str) {
        String result = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }
}
