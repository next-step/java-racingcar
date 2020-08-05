package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class stringTest {

    @Test
    @DisplayName("split 테스트")
    void spilt() {
        String str = "1,2";
        String strArr[] = str.split(",");

        assertThat(strArr).contains("1").contains("2");
        assertThat(strArr).hasSize(2);
        assertThat(strArr).containsExactly("1","2");
    }

    @Test
    @DisplayName("subString 테스트")
    void subString() {
        String str = "(1,2)";

        assertThat(str.substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 예외 발생 테스트")
    void charAt() {
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(3));


    }
}
