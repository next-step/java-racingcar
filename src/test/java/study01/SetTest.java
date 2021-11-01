package study01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("요구사항1 - size()로 Set의 크기 테스트")
    void sizeTest() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2 - contains()로 주어진 Value들이 존재하는지 확인")
    void containsTest01_check1to3(int containsValue) {
        boolean contains = numbers.contains(containsValue);
        assertThat(contains).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("요구사항3 - contains()로 주어진 Value들이 존재 유무 확인")
    void containsTest02_check1to5(int containsValue, boolean result) {
        boolean contains = numbers.contains(containsValue);
        assertThat(contains).isEqualTo(result);
    }
}
