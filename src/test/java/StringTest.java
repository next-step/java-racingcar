import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("1,2 를 , 로 split 하면 1과 2가 반환된다")
    @Test
    public void test() {
        String str = "1,2";

        String[] result = str.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("1을 , 로 split 하면 1이 반환된다")
    @Test
    public void test2() {
        String str = "1";

        String[] result = str.split(",");

        assertThat(result).containsExactly("1");
    }


    @DisplayName("(1,2) 값이 주어졌을 때 String 의 substring 메소드를 활용해 () 을 제거하고 1,2를 반환한다")
    @Test
    public void test3() {
        String str = "(1,2)";

        String result = str.substring(1, str.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("abc 값이 주어졌을 때 charAt 메소드를 활용해 특정 위치의 문자를 가져온다")
    @Test
    public void test4() {
        String str = "abc";

        char result = str.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @DisplayName("abc 값이 주어졌을 때 chatAt 메서드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다")
    @Test
    public void test5() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(str.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
