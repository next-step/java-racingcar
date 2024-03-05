import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("구분자 있는 문자열 분할 시 두 요소로 분리한다")
    void split1() {
        String data = "1,2";
        String[] result = data.split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("구분자 없는 단일 문자열 분할 시 단일 요소가 담긴 배열 반환한다")
    void split2() {
        String data = "1";
        String[] result = data.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("()를 가진 문자열의 ()를 제거하고 반환한다")
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 사용 시 위치값이 벗어나면 StringIndexOutOfBoundsException 발생한다")
    void charAt() {
        String data = "abc";
        assertThatThrownBy(() -> {
            data.charAt(data.length());
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }
}
