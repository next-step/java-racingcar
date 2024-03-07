package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

enum Numbers {
    ONE(1), TWO(2), THREE(3);

    private final int value;

    Numbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class SetTest {
    private Set<Integer> numbers;

    static Stream<Integer> provideNumbers() {
        return Stream.of(1, 2, 3);
    }

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항 1: 크기 확인")
    @Test
    void getSize_GivenSetThenReturnSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항 2-1: 포함 확인")
    @Test
    void contain_ThenShouldContainElements() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("요구사항 2-2: 포함 확인 - ValueSource")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void usingValueSource(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항 3: 포함 확인 - CsvSource")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void usingCsvSource(Integer input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

    @DisplayName("포함 확인 - NullSource")
    @ParameterizedTest
    @NullSource
    void usingNullSource(Integer input) {
        assertThat(numbers.contains(input)).isFalse();
    }

    @DisplayName("포함 확인 - EnumSource")
    @ParameterizedTest
    @EnumSource(Numbers.class)
    void usingEnumSource(Numbers number) {
        assertThat(numbers.contains(number.getValue())).isTrue();
    }

    @DisplayName("포함 확인 - MethodSource")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void usingMethodSource(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }
}