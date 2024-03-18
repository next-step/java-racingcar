package study;

import org.junit.jupiter.api.BeforeEach;
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

    // Test Case 구현
    @Test
    void checkSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
    void parameterizedTest(int num){
        assertThat(numbers.contains(num)).isTrue();
    }

    @CsvSource(value ={"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    @ParameterizedTest
    void CsvSourceTest(int element, boolean expected){
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }

}
