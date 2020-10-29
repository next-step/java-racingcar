package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // 요구사항 1
    @Test
    @DisplayName("set numbers size 확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    // 요구사항 2
    @DisplayName("ParameterizedTest 활용 중복제거")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int input) {
        assertTrue(numbers.contains(input));
    }

    // 요구사항 3
    @DisplayName("CsvSource 를 사용하여 4, 5 값인 경우 false 반환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsFalse(int input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }
}