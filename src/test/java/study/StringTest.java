package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항1 - 1,2 로 분할여부 확인")
    void split1() {
        String targetString = "1,2";

        String[] expectedResult = new String[]{"1", "2"};

        // then "1,2" -> "1" 존재 여부
        assertThat(targetString.split(",")).containsExactly(expectedResult);
    }

    @Test
    @DisplayName("요구사항1 - 1만 포함 여부")
    void split2() {
        String targetString = "1";

        String[] result = targetString.split(",");

        assertThat(result).containsOnly("1");
    }

    @Test
    @DisplayName("요구사항2 - 문자열자르기")
    void substring() {
        // given - "(1,2)"
        String targetString = "(1,2)";
        // when
        String result = targetString.substring(1, 4);
        // then
        String expectedResult = "1,2";
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("요구사항3 - 특정위치 문자열 조회 정상")
    void charAt() {
        char result = "abc".charAt(0);
//        char expectedChar = 'a';
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("요구사항3 - 범위 초과 오류 케이스")
    void charAt2() {

        assertThatThrownBy(()-> {"abc".charAt(3);}).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
