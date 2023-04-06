package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StringStudy {

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
}
