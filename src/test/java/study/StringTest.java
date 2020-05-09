package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void splitStudy() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void subStringStudy() {
        String inputString = "(1,2)".substring(1, 4);
        assertThat(inputString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오기")
    void charAtStudy() {
        String inputString = "abc";

        char result = inputString.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 테스트")
    void exceptionStudy() {
        String inputString = "abc";

        assertThatThrownBy(() -> {
            inputString.charAt(inputString.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}