import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void split_test() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");
        assertThat(data).containsExactly("1", "2");
    }

    @Test
    public void substring_test() {
        String data = "(1,2)".substring(1,4);
        assertThat(data).isEqualTo("1,2");

    }



    @Test
    @DisplayName("특정 위치의 문자를 찾는 테스트 케이스")
    public void findOutCharacter() {

        int index = 2;
        String data = "abc";

        assertThat(data.charAt(index)).isEqualTo('c');

        assertThatThrownBy(() -> {
                data.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
