import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @DisplayName("split 메소드가 정상 동작하는지 확인")
    @Test
    void split() {
        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1", "2");
    }

    @DisplayName("substring 메소드가 정상 동작하는지 확인")
    @Test
    void substring() {
        String target = "(1,2)";
        String substring = target.substring(1, target.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("charAt 메소드에서 특정 문자 위치를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    @Test
    void charAt_throwStringIndexOutOfBoundsException() {
        String target = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> target.charAt(target.length()));
    }
}
