package step1;

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
    @DisplayName("size 메서드를 통해 Set 크기 확인")
    void sizeTest() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("@ParameterizedTest를 통한 contains 메서드 테스트")
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int input) {
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @DisplayName("@CsvSource를 통한 contains 메서드 동적 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void dynamicContainsTest(Integer input, Boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
