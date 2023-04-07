package com.next.step.step2;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringSplitTest {

    @ParameterizedTest(name = "커스텀 구분자가 포함되지않는 경우")
    @MethodSource("provideNotCustomDelimiter")
    void splitInput_커스텀_구분자가_포함되지_않는_경우(String input, String[] expected) {
        String[] result = StringSplit.splitInput(input);
        assertThat(result).containsExactly(expected);
    }

    @ParameterizedTest(name = "커스텀 구분자를 포함하는 경우")
    @MethodSource("provideCustomDelimiter")
    void splitInput_커스텀_구분자를_포함하는_경우(String input, String[] expected) {
        String[] result = StringSplit.splitInput(input);
        assertThat(result).containsExactly(expected);
    }

    private Stream<Arguments> provideNotCustomDelimiter() {
        return Stream.of(
                Arguments.of("1,2,3", new String[]{"1", "2", "3"}),
                Arguments.of("1:2:3", new String[]{"1", "2", "3"}),
                Arguments.of("1:2,3", new String[]{"1", "2", "3"}),
                Arguments.of("1,2:3", new String[]{"1", "2", "3"})
        );
    }

    private Stream<Arguments> provideCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", new String[]{"1", "2", "3"}),
                Arguments.of("//~\n1~2~3", new String[]{"1", "2", "3"})
        );
    }
}
