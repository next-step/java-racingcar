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
    @DisplayName("hashSet 크기를 검증한다.")
    void sizeTest() {
        int expectedResult = 3;

        int result = numbers.size();

        assertThat(result).isEqualTo(expectedResult);
    }

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    @DisplayName("파라미터에 값을 설정하고, hashSet의 포함된 값을 검증한다.")
    void containsTest(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("파라미터에 값과 예상 결과를 설정하고, hashSet의 포함된 값을 검증한다.")
    void containsTest(int value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
