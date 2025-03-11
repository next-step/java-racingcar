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

    // Test Case 구현
    @Test
    @DisplayName("1. size() 메소드를 활용해 Set의 크기를 확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }



    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("2. contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("3. 1,2,3 인 경우 True, 그 외의 경우 False")
    void returnsTrue_ifSetContainsOneTwoThree(int input, boolean output) {
        assertThat(numbers.contains(input)).isEqualTo(output);
    }
}
