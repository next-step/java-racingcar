import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("step1")
public class TestStep1String {

    @Test
    @DisplayName("요구사항 1 : \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void splitByComma() {
        final String inputData = "1,2";
        final String[] expected = {"1","2"};

        final String[] actual = inputData.split(",");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("요구사항 1 : \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환")
    void splitOne() {
        final String inputData = "1";
        final String[] expected = {"1"};

        final String[] actual = inputData.split(",");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("요구사항 2: \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    void splitBetweenBracket() {
        final String inputData = "(1,2)";
        final String[] expected = {"1","2"};

        final String[] actual = inputData.substring(1, inputData.length()-1).split(",");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("요구사항 3 : \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오기")
    void extractChar() {
        final String inputData = "abc";
        final String expected = "c";

        final char actual = inputData.charAt(2);

        Assertions.assertEquals(expected.charAt(0),actual);
    }

    @Test
    @DisplayName("abc 문자열이 있을때 index 10 번째 위치의 문자를 가져오면 IndexOutOfBoundsException 발생")
    void handelIndexOutOfBoundsException() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = "abc".charAt(9);
                }).withMessageMatching("String index out of range: \\d+");
    }

}

