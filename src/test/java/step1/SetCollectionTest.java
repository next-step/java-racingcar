package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set contains test")
    @MethodSource
    void containsTest(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

    static Stream<Arguments> containsTest() {
        return Stream.of(
                Arguments.of(
                        1, Boolean.TRUE
                ),
                Arguments.of(
                        2, Boolean.TRUE
                ),
                Arguments.of(
                        5, Boolean.FALSE
                )
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true"}, delimiter = ':')
    void csvTest(int number , boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
