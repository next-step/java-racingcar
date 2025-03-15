package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    public void splitTest() {
        String str = "1,2";
        String[] actual = str.split(",");
        String[] expected = new String[] {"1", "2"};
        Assertions.assertThat(actual).containsExactly(expected);
    }

    @Test
    @DisplayName("String 길이보다 큰 index로 charAt 호출 시 StringIndexOutOfBoundsException이 발생해야 한다")
    public void charAtTest() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
