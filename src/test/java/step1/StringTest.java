package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("문자열을 split 했을 때 있는 값을 가져오는데 성공하는 케이스")
    public void stringSplitTest1() {
        String value = "1, 2";
        String[] splitValues =  value.split(",");
        assertThat(splitValues[0]).contains("1");
    }

    @Test
    @DisplayName("문자열을 split했을 때 정확한 값을 확인하는데 성공하는 케이스")
    public void stringSplitTest2() {
        String value = "1, 2";
        String[] splitValues =  value.split(",");
        assertThat(splitValues[1]).contains("2");
    }

    @Test
    @DisplayName("split 대상이 없는 문자열을 split해도 값을 가져오는데 성공하는 케이스")
    public void stringSplitTest3() {
        String value = "1";
        String[] splitValues =  value.split(",");
        assertThat(splitValues).containsExactly("1");
    }

    @Test
    @DisplayName("괄호가 포함된 문자열의 괄호를 뺀 나머지 값을 가져오는데 성공하는 케이스")
    public void stringWithParenthesisTest() {
        String value = "(1,2)";
        String onlyNumbers = value.substring(1, value.length() - 1);
        assertThat(onlyNumbers).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 길이보다 긴 위치의 문자열을 가져올 때 실패하는 케이스")
    public void specificCharacterTest() {
        String alphabets = "abc";
        assertThatThrownBy(() -> alphabets.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
