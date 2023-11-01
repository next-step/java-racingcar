package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    void 요구사항1(){
        int expectedResult = 3;
        assertThat(numbers.size()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 요구사항2(int input){
        assertThat(numbers.contains(input)).isTrue();
    }
}
