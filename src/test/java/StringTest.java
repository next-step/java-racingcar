import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("[요구사항1] 1,2를 콤마(,)로 split 했을 때 1과 2로 잘 분리된다.")
    public void splitTest1() {
        String given = "1,2";
        String[] actual = given.split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("[요구사항1] 1을 콤마(,)로 split 했을 때 1만 포함하는 배열이 반환된다.")
    public void splitTest2() {
        String given = "1";
        String[] actual = given.split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("[요구사항2] (1,2) 값을 substring 으로 () 제거하고 1,2를 반환할 수 있다.")
    public void substringTest1() {
        String given = "(1,2)";
        String actual = given.substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("[요구사항3] abc가 주어졌을 때 chatAt 메서드로 특정 위치의 문자를 가져올 수 있다.")
    public void charAtTest1() {
        String given = "abc";

        char a = given.charAt(0);
        assertThat(a).isEqualTo('a');

        char b = given.charAt(1);
        assertThat(b).isEqualTo('b');

        char c = given.charAt(2);
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("[요구사항3] chatAt는 위치 값을 벗어나면 StringIndexOutOfBoundException을 던진다.")
    public void charAtTest2() {
        String given = "abc";

        assertThatThrownBy(() -> {
            char unknown = given.charAt(9999);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessage("String index out of range: 9999");
    }
}
