import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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

}
