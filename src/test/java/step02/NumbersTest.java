package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumbersTest {

    @ParameterizedTest
    @DisplayName("숫자 합을 확인한다.")
    @MethodSource("numberListProvider")
    void sumTest(List<Number> numberList, Number expectedNumber) {
        //when
        Numbers numbers = new Numbers(numberList);

        //then
        assertThat(numbers.sum()).isEqualTo(expectedNumber);
    }

    static Stream<Arguments> numberListProvider() {
        return Stream.of(
                arguments(Collections.emptyList(), new Zero()),
                arguments(List.of(new Zero()), new Zero()),
                arguments(
                        List.of(new Zero(), new PositiveNumber(1), new PositiveNumber(2)),
                        new PositiveNumber(3)
                ),
                arguments(
                        List.of(new PositiveNumber(1), new PositiveNumber(2), new PositiveNumber(3)),
                        new PositiveNumber(6)),
                arguments(
                        List.of(new PositiveNumber(3), new PositiveNumber(4), new PositiveNumber(5)),
                        new PositiveNumber(12)
                )
        );
    }

}