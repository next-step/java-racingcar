package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @DisplayName("콤마를 분리")
    @ParameterizedTest(name = "\"{0}\" -> {1} ")
    @MethodSource
    void splitByComma(String target, String[] expected) {
        //when
        String[] split = target.split(",");
        //then
        assertThat(split).contains(expected);
    }

    private static Stream<Arguments> splitByComma() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1","2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }

    @Test
    @DisplayName("맨앞과 맨뒤 괄호를 제거")
    void removeBracket(){
        String target = "(1,2)";
        String substring = target.substring(1, target.length()-1);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("문자열에 원하는 위치 지정시 문자를 반환")
    @ParameterizedTest(name = "{0}번째 문자는 {1}")
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    void charAtSuccess(int index, char expected){
        String target = "abc";
        char actual = target.charAt(index);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("주어진 문자의 최대 배열을 벗어나면 IndexOutOfBoundsException 발생")
    @Test
    void charAtThrowIndexOutOfBoundsException(){
        String target = "abc";
        assertThatThrownBy(() -> target.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
