import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("step1")
public class TestStep1String {

    @Test
    @DisplayName("req1_1")
    void request1_1() {
        /* 요구 1 */
        final String inputData = "1,2";

        final String[] expected = {"1","2"};

        final String[] actual = inputData.split(",");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("req1_2")
    void request1_2() {
        /* 요구 1 */
        final String inputData = "1";

        final String[] expected = {"1"};

        final String[] actual = inputData.split(",");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("req2")
    void request2() {
        /* 요구 2 */
        final String inputData = "(1,2)";

        final String[] expected = {"1","2"};

        final String[] actual = inputData.substring(1, inputData.length()-1).split(",");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("req3_1")
    void request3_1() {
        /* 요구 3 */
        final String inputData = "abc";

        final String expected = "c";

        final char actual = inputData.charAt(2);

        Assertions.assertEquals(expected.charAt(0),actual);
    }

    @Test
    @DisplayName("req3_2")
    void request3_2() {
        /* 요구 3 */
        final String inputData = "abc";

        final String expected = "c";

        final char actual = inputData.charAt(2);

        Assertions.assertEquals(expected.charAt(0), actual);
    }

    @Test
    @DisplayName("abc 문자열이 있을때 index 10 번째 위치의 문자를 가져오면 IndexOutOfBoundsException 발생")
    void stringIndexOutOfBoundsException() {
        /* 요구 3 */
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = "abc".charAt(9);
                }).withMessageMatching("String index out of range: \\d+");
    }

}

