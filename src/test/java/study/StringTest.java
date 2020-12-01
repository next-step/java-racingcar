package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("[요구사항1] 1,2를 ,로 split 했을 때 1과 2로 분리")
    public void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("[요구사항1] 1를 ,로 split 했을 때 1만을 포함하는 배열을 반환")
    public void splitExactly() {
        String[] splitArr = "1".split(",");
        assertThat(splitArr).containsExactly("1");
    }

    @Test
    @DisplayName("[요구사항2] (1,2) 값에서 ()를 제거하고 1,2를 반환")
    void substring() {
        String input = "(1,2)";
        String result = input.substring(input.indexOf("(")+1, input.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("[요구사항3] abc 값에서 특정 위치의 문자를 반환")
    public void getLocationChar() {
        String result = "abc";
        char[] dataCharArr = result.toCharArray();
        for (int i=0; i<dataCharArr.length; i++) {
            assertThat(result.charAt(i)).isEqualTo(dataCharArr[i]);
        }
    }

    @Test
    @DisplayName("[요구사항3] 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    public void stringIndexOutOfBoundsException() {
        String result = "abc";
        assertThatThrownBy(() -> {
            result.charAt(result.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}

