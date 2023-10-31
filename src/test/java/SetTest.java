import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("size()를 활용해 Set의 크기를 테스트한다.")
    @Test
    void sizeTest() {
        // when & then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains()를 활용해 존재하는 값을 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void isContainValues(int number) {
        // when & then
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("contains()를 활용해 값의 존재 여부를 확인한다.")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true","4,false","5,false"})
    void isContainValues2(int number, boolean expectedResult) {
        // when & then
        boolean realResult = numbers.contains(number);
        assertEquals(realResult, expectedResult);
    }
}
