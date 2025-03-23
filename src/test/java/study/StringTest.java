package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("'1,2'가 입력되었을 때, 1과 2로 분리된다.")
    public void splitTwoInputNumberTest() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("'1'이 입력되었을 때, 1만을 포함하는 배열을 반환한다.")
    public void splitOneInputNumberTest() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 substring() 메소드를 사용해 ()을 제거한다.")
    public void subStringTest() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때, String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다")
    public void getSpecificCharacterByCharAtTest() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt()을 사용할 때, 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
    public void wrongIndexThrowsExceptionTest() {
        String test = "abc";
        int index = 10;
        assertThatThrownBy(() -> test.charAt(index)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageStartingWith("String index out of range: " + index);
        ;
    }

}
