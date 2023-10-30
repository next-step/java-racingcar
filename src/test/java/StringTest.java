import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @ParameterizedTest(name = "문자열 : {0}, 배열 : {1}")
    @MethodSource("StringAndArray")
    @DisplayName("성공 - 숫자가 포함 되어 있는 문자열을 쉼표로 분리 했을 때 순서에 맞게 분리 된다.")
    void success_split_test(String given, String[] expected){
        //when
        String[] splitedString = given.split(",");

        //then
        assertThat(splitedString).containsExactly(expected);
    }

    private static Stream<Arguments> StringAndArray() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }

    @Test
    @DisplayName("성공 - \"(1,2)\"에서 ()을 제거하고 \"1,2\"를 반환한다.")
    void success_substring_test(){
        //given
        String given = "(1,2)";
        String expected = "1,2";
        String deleteTarget1 = "(";
        String deleteTarget2 = ")";

        //when
        String substring = given.substring(given.indexOf(deleteTarget1) + 1, given.lastIndexOf(deleteTarget2));

        //then
        assertThat(substring).isEqualTo(expected);
    }

    @ParameterizedTest(name = "문자열 : {0}, 인덱스 : {1}, 문자 : {2}")
    @MethodSource("provideStringAndIndexAndChar")
    @DisplayName("성공 - 문자열에서 특정 위치의 문자를 가져올 수 있다.")
    void success_chatAt_test(String given, int index, char expected){
        //when
        char character = given.charAt(index);

        //then
        assertThat(character).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringAndIndexAndChar() {
        return Stream.of(
                Arguments.of("abc", 0, 'a'),
                Arguments.of("abc", 1, 'b'),
                Arguments.of("abc", 2, 'c')
        );
    }

    @Test
    @DisplayName("실패 - 문자열에서 특정 위치의 문자를 가져올 때 위치 값에 벗어 나서 예외가 발생한다.")
    void fail_chatAt_out_of_index_test(){
        //given
        String given = "abc";
        int outOfIndex = 3;

        //when & then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> given.charAt(outOfIndex)).withMessageMatching("String index out of range: 3");

    }

}
