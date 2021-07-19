package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 분리되는지 테스트")
    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 테스트")
    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환되는지 테스트")
    @Test
    void substring() {
        String str = "(1,2)";

        int beginIndex = str.indexOf("(") + 1;
        int endIndex = str.indexOf(")");

        str = str.substring(beginIndex,endIndex);

        assertThat(str).contains("1");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 사용해 특정 위치의 문자를 가져오는지 테스트")
    @ParameterizedTest
    @CsvSource({"0,a", "1,b", "2,c"})
    void charAt1(int index, char ch) {
        String str = "abc";
        assertThat(str.charAt(index)).isEqualTo(ch);
    }

}
