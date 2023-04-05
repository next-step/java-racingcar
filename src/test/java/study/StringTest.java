package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void testSplit1() {
        var result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1 - \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void testSplit2() {
        var result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 - \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void testSplit3() {
        var source = "(1,2)";
        var expected = "1,2";

        var actual = source.substring(1, source.length() - 1);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("요구사항3 - charAt을 통한 해당 위치 문자 가져오기 : 성공")
    @MethodSource("split4SuccessArguments")
    @ParameterizedTest
    void testSplit4Success(int index, char expected) {
        var source = "abc";

        var actual = source.charAt(index);

        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> split4SuccessArguments() {
        return Stream.of(
                Arguments.of(0, 'a'),
                Arguments.of(1, 'b'),
                Arguments.of(2, 'c')
        );
    }

    @Test
    @DisplayName("요구사항3 - charAt을 통한 해당 위치 문자 가져오기 : 실패")
    void testSplit4Failure() {
        var source = "abc";
        var expect = StringIndexOutOfBoundsException.class;
        var expectedMsg = "String index out of range";

        assertThatThrownBy(() -> source.charAt(3))
                .isInstanceOf(expect)
                .hasMessageContaining(expectedMsg);
    }
}
