package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculateSeparatorTest {

    private final StringCalculateSeparator stringCalculateSeparator = new StringCalculateSeparator();

    @Test
    @DisplayName("콤마 구분자 테스트")
    void commaTest() {

        List<String> separateList = stringCalculateSeparator.executeSeparator("1,2").getInputList();

        assertThat(separateList).containsExactly("1", "2");
    }

    @Test
    @DisplayName("콜론 구분자 테스트")
    void colonTest() {

        List<String> separateList = stringCalculateSeparator.executeSeparator("1:2").getInputList();

        assertThat(separateList).containsExactly("1", "2");
    }

    @Test
    @DisplayName("콤마 콜론 구분자가 섞였을때 테스트")
    void commaColonTest() {

        List<String> separateList = stringCalculateSeparator.executeSeparator("1:2,3:4").getInputList();

        assertThat(separateList).containsExactly("1", "2", "3", "4");
    }

    @ParameterizedTest
    @MethodSource("custom")
    @DisplayName("커스텀 구분자 테스트")
    void customTest(String input, List<String> inputList) {

        List<String> separateList = stringCalculateSeparator.executeSeparator(input).getInputList();

        assertThat(separateList).isEqualTo(inputList);
    }

    static Stream<Arguments> custom() {

        return Stream.of(
                Arguments.arguments("//~\n1~2~3", Arrays.asList("1", "2", "3")),
                Arguments.arguments("//f\n1f2f3", Arrays.asList("1", "2", "3")),
                Arguments.arguments("//#\n1#2#3", Arrays.asList("1", "2", "3"))
        );
    }

    @Test
    @DisplayName("구분자가 없을 때 입력값")
    void noTest() {

        List<String> separateList = stringCalculateSeparator.executeSeparator("1").getInputList();

        assertThat(separateList).containsExactly("1");
    }
}