package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SetCollectionStudyTest {
    private Set<Integer> numbers;

    @BeforeEach
    void init() {
        numbers = new HashSet<>(Arrays.asList(1, 1, 2, 3));
    }

    @Test
    @DisplayName("Set 의 크기")
    void sizeOfSet() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Set 내부에 값이 존재하는지 contains 테스트")
    void contains(int targetNumber, boolean expectedResult) {
        assertThat(numbers.contains(targetNumber)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> contains() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(4, false)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Set 내부에 값이 존재하는지 contains 비효율적인 테스트")
    void inefficientContainsTest(int targetNumber) {
        assertThat(numbers.contains(targetNumber)).isTrue();
    }

    private static Stream<Arguments> inefficientContainsTest() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3)
       );
    }
}
