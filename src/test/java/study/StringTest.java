package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringTest {

    @Test
    @DisplayName("문자열을 ','로 split() 했을 때 리턴되는 배열 확인")
    void split(){
        String[] strArray = "1,2".split(",");
        String[] strArray2 = "1".split(",");

        assertThat(strArray).contains("1", "2");
        assertThat(strArray).containsExactly("1", "2");
        assertThat(strArray2).containsOnly("1");
    }

    @Test
    @DisplayName("문자열을 substring()을 사용하여 괄호 제거 후 값 확인")
    void substring(){
        String str = "(1,2)".substring(1,4);
        assertThat(str).isEqualTo("1,2");
    }
    @Test
    @DisplayName("String 의 charAt() 메소드를 활용해서 특정 위치의 문자 값 리턴 후 확인")
    public void charAt(){
        char str = "abc".charAt(0);
        assertThat(str).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt()을 사용하여 특정 위치의 문자를 가져올 때 " +
                "위치 값을 벗어나는 경우의 예외 테스트")
    void charAtOutOfBound(){
        String str = "abc";
        int idx = str.length();
        String expectedMessage = "String index out of range: "+idx;

        assertThatThrownBy(() -> str.charAt(idx))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(expectedMessage);
    }
}
