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

}
