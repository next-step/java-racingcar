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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private static final char DELIMITER = ':';

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
    @DisplayName("요구사항1 : Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2 : contains() 를 활용하여 1,2,3 값이 있는지 확인한다.")
    void containsTest(int target) {
        assertTrue(numbers.contains(target));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:true",
            "2:true",
            "3:true",
            "4:false",
            "5:false",
    }, delimiter = DELIMITER)
    @DisplayName("요구사항3 : 입력 값에 따라 결과 값이 다른 경우의 테스트")
    void strictContainsTest(int target, boolean expected) {
        assertEquals(numbers.contains(target), expected);
    }
}
