package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    public void getCharInStringTest() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String과 index가 주어졌을 때, index로 해당 String의 charAt() 메소드에서 " +
        "IndexOutOfBoundsException이 발생하는지 여부를 테스트 한다.")
    public void getCharInStringExceptionTest() {
        assertThatThrownBy(() -> {
            assertThat("abc".charAt(3)).isEqualTo('c');
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            assertThat("abc".charAt(3)).isEqualTo('c');
        }).withMessageMatching("String index out of range: \\d+");
    }

    @Test
    @DisplayName("예제에 있던 IndexOutOfBoundsException 과 Regx 사용한 내용 확인 테스트 메소드")
    public void getCharInList() {
        List<Character> charList = new ArrayList<>();
        charList.add('a');
        charList.add('b');
        charList.add('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            assertThat(charList.get(3)).isEqualTo('c');
        }).withMessageMatching(
            "Index \\d+ out of bounds for length \\d+"
        );

    }
}
