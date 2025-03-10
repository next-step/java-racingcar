package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Nested
    @DisplayName("sizeTest")
    class SizeTest {

        @Test
        @DisplayName("size가 반환 되는가?")
        void sizeTest() {
            // then
            Assertions.assertThat(numbers.size()).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("containsTest")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ContainsTest {

        @ParameterizedTest
        @MethodSource("containsTestData")
        @DisplayName("contains 메소드는 값이 존재하는지 확인하는가?")
        void containsTest(int testData, boolean expected) {
            // then
            Assertions.assertThat(numbers.contains(testData)).isEqualTo(expected);
        }

        Stream<Arguments> containsTestData() {
            return Stream.of(
                    Arguments.of(1, true),
                    Arguments.of(2, true),
                    Arguments.of(3, true),
                    Arguments.of(4, false),
                    Arguments.of(4, false)
            );
        }
    }
}
