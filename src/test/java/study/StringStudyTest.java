package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class StringStudyTest {

    @DisplayName("문자열 '1,2'를 ',' 기준으로 분리할 수 있다")
    @Test
    void slitComma() {
        int one = 1;
        int two = 2;
        String numbersWithComma = one + "," + two;

        final List<Integer> numbers = Arrays.stream(numbersWithComma.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        assertThat(numbers).contains(one, two);
    }

    @DisplayName("문자열 '(1,2)'를 '()'를 제거하고 '1,2'를 반환할 수 있다")
    @Test
    void substringTest() {
        String numbersWithParentheses = "(1,2)";
        String numbersWithoutParentheses = "1,2";

        final String result = numbersWithParentheses.substring(1, numbersWithParentheses.length() - 1);

        assertThat(result).isEqualTo(numbersWithoutParentheses);
    }

    @DisplayName("'abc' 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 수 있다, " +
            "범위를 벗어나면 StringIndexOutOfBoundsException 이 발생한다")
    @Test
    void charAtTest() {
        String fiveCharactersWord = "12345";
        int inBoundIndex = 4;
        int outBoundIndex = 5;

        assertThatCode(() -> fiveCharactersWord.charAt(inBoundIndex))
                .doesNotThrowAnyException();

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> fiveCharactersWord.charAt(outBoundIndex))
                .withMessageMatching("String index out of range: \\d+");

    }
}
