import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("step01 - String 클래스에 대한 학습테스트")
public class StringPlaygroundTest {

    @DisplayName("요구사항1 - split 테스트")
    @Test
    public void splitString_toArray() {
        String givenString = "1,2";
        String[] result = givenString.split(",");
        assertThat(result).hasSize(2);
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항2 - substring 테스트")
    @Test
    public void substring_getString() {
        String givenString = "(1,2)";
        String result = givenString.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항3 - charAt()을 이용한 특정위치의 문자를 가져온다")
    @Test
    public void charAt_getChar() {
        String givenString = "abc";
        char result = givenString.charAt(1);
        assertThat(result).isEqualTo('b');

    }

    @DisplayName("요구사항4 - 특정위치의 문자를 가져올 때 범위를 벗어나면 exception")
    @Test
    public void charAtFail_outOfRange() {
        String givenString = "abc";
        assertThatThrownBy( () -> givenString.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 3");

    }
}
