package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @DisplayName("요구사항 1 : '1,2'을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다."
            + "'1'을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    @Test
    void split() {
        String separator = ",";
        String sampleText = "1,2";
        String[] resultArray = sampleText.split(separator);
        assertThat(resultArray).contains("1");
        assertThat(resultArray).contains("2");
        assertThat(resultArray).containsExactly("1", "2");

        sampleText = "1";
        resultArray = sampleText.split(separator);
        assertThat(resultArray).contains("1");
    }

    @DisplayName("요구사항 2 : '(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환하도록 구현한다.")
    @Test
    void substring() {
        String sampleText = "(1,2)";
        assertThat(sampleText.substring(sampleText.indexOf("(") + 1, sampleText.indexOf(")"))).isEqualTo("1,2");
    }

    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    @Test
    void charAt() {
        assertThat("abc".charAt(1)).isEqualTo('b');
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면" +
            "StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    @Test
    void stringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);

        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
