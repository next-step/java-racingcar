package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        String testData= "1,2";
        String[] result= testData.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void splitWithTailingDelimiter() {
        String testData= "1,";
        String[] result= testData.split(",");
        assertThat(result).containsExactly("1");
    }


    @Test
    void substring() {
        String testData="(1,2)";
        String result = testData.substring(1, testData.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스의 chartAt 메소드를 활용해 특정 위치의 문자를 가져오는 테스트")
    void charAt() {
        String testData="abc";
        char firstChar=testData.charAt(0);
        char secondChar=testData.charAt(1);
        char thirdChar=testData.charAt(2);

        assertThat(firstChar).isEqualTo('a');
        assertThat(secondChar).isEqualTo('b');
        assertThat(thirdChar).isEqualTo('c');
    }

    @Test
    @DisplayName("String 클래스의 charAt 메소드 사용시 가져올 문자의 위치가 문자열에서 벗어날시 StringIndexOutOfBoundsException발생 테스트")
    void charAtWithInvalidIdx() {
        String testData="abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                  testData.charAt(testData.length()+1);
                }).withMessageMatching("String index out of range: \\d");
    }


}
