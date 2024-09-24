import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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

    // Test Case 구현

    @Test
    @DisplayName("set size 테스트")
    void setSizeTest() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set의 값 존재 여부 테스트")
    void setContainsElementsTest(int idx) {
        Assertions.assertThat(numbers.contains(idx)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("set의 다양한 결과값 테스트")
    void setContainsMultiValueTest(String value, String expected) {
        int inputValue = Integer.parseInt(value);
        boolean expectedResult = Boolean.parseBoolean(expected);
        Assertions.assertThat(numbers.contains(inputValue)).isEqualTo(expectedResult);
    }
}
