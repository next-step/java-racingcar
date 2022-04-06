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
    void sumTest(List<Number> numberList, int expectedSum) {
        //when
        Numbers numbers = new Numbers(numberList);

        //then
        assertThat(numbers.sum()).isEqualTo(new Number(expectedSum));
    }

    static Stream<Arguments> numberListProvider() {
        return Stream.of(
                arguments(Collections.emptyList(), 0),
                arguments(List.of(new Number(0)), 0),
                arguments(List.of(new Number(0), new Number(1), new Number(2)), 3),
                arguments(List.of(new Number(1), new Number(2), new Number(3)), 6),
                arguments(List.of(new Number(3), new Number(4), new Number(5)), 12)
        );
    }

}