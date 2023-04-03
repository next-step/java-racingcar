import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringClassTest {

    @Test
    public void split_V1() {
        String str = "1,2";
        String[] val = str.split(",");

        assertThat(val).contains("1", "2");
    }

    @Test
    public void split_V2() {
        String str = "1";
        String[] val = str.split(",");

        assertThat(val).containsExactly("1");
    }

    @Test
    public void subString() {
        String str = "(1,2)";
        String strSubstring = str.substring(1, 4);

        assertThat(strSubstring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    public void charAt() {
        String str = "abc";

        // charAt(i), if (i < 0 || i >= 3) StringIndexOutOfBoundsException 발생
        assertThatThrownBy(() -> str.charAt(-1))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range");
    }


}
