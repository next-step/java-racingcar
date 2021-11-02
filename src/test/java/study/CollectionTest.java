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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTest {

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
    @DisplayName("요구사항 1: Set 크기를 확인하는 테스트")
    void collectionSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("요구사항 2: Set에 1, 2, 3 값이 존재하는지 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void containsParameterizedTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("요구사항 3: 4 미만이면 참")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void trueIfLessThan4(int input, boolean expected) {
        assertEquals(input < 4, expected);
    }
}
