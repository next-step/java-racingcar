package study.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
    }

    @Test
    @DisplayName("hashSet은 중복 데이터를 허용하지 않는다.")
    void getSize() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("ParameterizedTest를 활용해 중복 코드를 제거한다.")
    void parameterAnnotationTest(int input) {
        assertThat(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "4:false", "3:true", "2:true", "5:false"}, delimiter = ':')
    @DisplayName("CsvSource를 활용해 하나의 테스트에서 true, false를 모두 확인한다.")
    void trueFalseUsingCsvSourceTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
