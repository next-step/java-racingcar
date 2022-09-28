package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringTest {
    @Test
    @DisplayName("split메소드가 지정한문자를 기준으로 정상적으로 분리되어야 함")
    void split() {
        String givenData = "1,2";
        String[] result = givenData.split(",");
        assertThat(result).contains("1","2");
        assertThat(result).containsExactly("1","2");
    }

//    @Test
//    void substring() {
//        String givenData = "(1,2)";
//        String result = givenData.substring(1, 4);
//        System.out.println(result);
//    }

    String substring(String givenData) {
        return givenData.substring(1, 4);
    }

    @Test
    @DisplayName("charAt메소드가 지정한 위치의 문자를 char로 반환 해야함")
    void charAt_success() {
        String givenData = "abc";
        assertThat(givenData.charAt(0)).isEqualTo('a');
        assertThat(givenData.charAt(1)).isEqualTo('b');
        assertThat(givenData.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt메소드가 문자열의 길이를 벗하는 index를 지정했을때 StringIndexOutOfBoundsException가 발생해야함")
    void charAt_fail() {
        String givenData = "abc";
        Throwable thrown = catchThrowable(() -> { givenData.charAt(4); });
        assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
