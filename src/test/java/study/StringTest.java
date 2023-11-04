package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 분리되고, \"1\"만 split 했을 때 1을 포함하는 배열을 반환한다.")
    @Test
    void split_req1() {
        // given
        String givenString1 = "1,2";
        String givenString2 = "1";

        // when
        String[] splitStringArray1 = givenString1.split(",");
        String[] splitStringArray2 = givenString2.split(",");

        // then
        assertThat(splitStringArray1).containsExactly("1", "2");
        assertThat(splitStringArray2).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환한다.")
    @Test
    void split_req2() {
        // given
        String givenString = "(1,2)";

        // when
        String result = givenString.substring(1, givenString.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String.charAt() 은 특정 위치의 문자를 가져오고, 위치 값 범위를 벗어나면 StringIndexOutOfBoundsException을 발생시킨다.")
    @Test
    void split_req3() {
        // given
        String givenString = "abc";
        int testIndex = givenString.length();

        // when
        char result = givenString.charAt(2);

        // then
        assertThat(result).isEqualTo('c');
        assertThatThrownBy(() -> givenString.charAt(testIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

    @DisplayName(",를 포함하지 않아도 문자열이 포함된 String[]을 반환한다.")
    @Test
    void splitTest() {
        assertThat("1".split(","))
                .hasSize(1)
                .containsExactly("1");
    }

    @DisplayName(", 또는 : 으로 문자열을 split 한다")
    @Test
    void splitDelimiterTest() {
        assertThat("1,2:3".split("[,:]"))
                .hasSize(3)
                .containsExactly("1", "2", "3");
    }

    @DisplayName("//와 \\n 사이 문자열을 추출한다")
    @Test
    void delimiterParseTest() {
        // given
        String testString = "//;\\n123";
        String delimiter = null;
        Pattern pattern = Pattern.compile("//(.*?)\\\\n(.*?)");

        // when
        Matcher matcher = pattern.matcher(testString);
        matcher.find();
        delimiter = matcher.group(1);


        assertThat(delimiter)
                .isEqualTo(";");
    }

    @DisplayName("//와 \\n 사이 문자열 없다면 빈 문자열을 리턴한다")
    @Test
    void delimiterParseTest2() {
        // given
        String testString = "//\\n123";
        String delimiter = null;
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");

        // when
        Matcher matcher = pattern.matcher(testString);
        if (matcher.find()) {
            delimiter = matcher.group(1);
        }

        assertThat(delimiter)
                .isEqualTo("");
    }


}
