package step2;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    @Test
    @DisplayName("여러개의 구분자를 split 하는 기능 테스트")
    public void splitTest() {
        String[] actual = "1,2:3@4".split(",|:|@");
        Assertions.assertThat(actual).contains("1", "2", "3", "4");
    }

    @Test
    @DisplayName("커스터마이징 구분자 파싱 테스트")
    public void patternTest(){
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher("//#\n1#2#3");

        Assertions.assertThat(matcher.find()).isTrue();

        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);

        Assertions.assertThat(customDelimiter).isEqualTo("#");
        Assertions.assertThat(tokens).containsExactly("1", "2", "3");

    }

    @Test
    public void parseInteger() {
        int number1 = Integer.parseInt("1");
        int number2 = Integer.parseInt("a");
        Assertions.assertThat(number1 + number2).isEqualTo(3);  
    }
}
