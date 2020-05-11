package study.step1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


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
    @DisplayName("Set 크기 확인 테스트")
    @Test
    void checkSetSize(){
        int size = 3;
        assertThat(numbers.size()).isEqualTo(size);
    }

    @DisplayName("Set 원소들이 input값과 동일한지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void compareSetValuesToInputs(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("입력 값에 따라 결과 값이 다른 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkNumberBooleanPairValues(int inputNumber, boolean expectedResult) {
        assertThat(numbers.contains(inputNumber)).isEqualTo(expectedResult);
    }
}