package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Set Collection에 대한 학습 테스트")
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

    @DisplayName("Set Collection 의 개수를 확인한다")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set Collection 에 값이 포함되어 있으면 true 를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set Collection 에 값이 포함되어 있으면 true, 포함되어 있지 않으면 false 를 반환한다")
    @ParameterizedTest
    @CsvSource(value = { "1,true", "2,true", "3,true", "4,false", "5,false" })
    void contains(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
    }

    @DisplayName("Set Collection 에 값이 포함되어 있으면 true, 포함되어 있지 않으면 false 를 반환한다")
    @ParameterizedTest
    @MethodSource("containsValueCase")
    void containsArguments(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
    }

    private static Stream<Arguments> containsValueCase() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(4, false),
                Arguments.of(5, false)
        );
    }
}
