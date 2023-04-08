package com.next.step.step2;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SumNumberTest {

    @ParameterizedTest(name = "나눠진 숫자 배열의 합을 구하는 경우")
    @MethodSource("provideNumberArray")
    void sumSplitNumbers_숫자_배열_합(String[] input, int expected) {
        int result = SumNumber.sumSplitNumbers(input);
        assertThat(result).isEqualTo(expected);
    }

    private Stream<Arguments> provideNumberArray() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3"}, 6),
                Arguments.of(new String[]{"2", "3", "4"}, 9),
                Arguments.of(new String[]{"3", "4", "5"}, 12)
        );
    }
}
