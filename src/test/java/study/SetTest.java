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
    @DisplayName("Set의 size 메소드를 활용해 Set의 크기를 확인한다.")
    void checkSetSize() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }


    @ParameterizedTest(name = "요구사항3-1 - 숫자 {0} 확인")
    @ValueSource(ints = {1,2,3})
    void checkSetNumbers(Integer nums) {
        assertThat(numbers.contains(nums)).isTrue();
    }

    @ParameterizedTest(name = "요구사항3-2 - 숫자 {0} 확인")
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void checkSetNumbers2(Integer nums, Boolean result) {
        assertThat(numbers.contains(nums)).isEqualTo(result);
    }
}
