package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set Collection의 사이즈 테스트")
    void sizeOfSetTest() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("ParameterizedTest를 활용하여 원소의 존재여부 테스트")
    @ValueSource(ints = {1, 2, 3})
    void containsTrueTest(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @DisplayName("ParameterizedTest를 사용하여 원소의 존재여부 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTrueAndFalseTest(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}   