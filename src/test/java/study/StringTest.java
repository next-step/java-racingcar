package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항 1 - \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void splitCheckContainsExactly() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 1 - \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void splitCheckContains() {
        String[] result = "1".split(",");

        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("요구사항 2 - \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void substringCheck() {
        String s = "(1,2)";
        String result = s.substring(1,s.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 - \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void charAtCheck() {
        String s = "abc";

        assertThat(s.charAt(0)).isEqualTo('a');
        assertThat(s.charAt(1)).isEqualTo('b');
        assertThat(s.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항 3 - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 " +
            "위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void stringIndexOutOfBoundsExceptionCheck() {
        String s = "abc";


        assertThrows(StringIndexOutOfBoundsException.class,
                () -> s.charAt(s.length()));
    }
}
