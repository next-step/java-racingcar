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
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("Set의 크기 확인")
    void checkSize(){
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
        assertEquals(3, size);
    }

    @DisplayName("중복 코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3} )
    void contains(int i) {
        assertThat(numbers.contains(i)).isTrue();
    }

    @DisplayName("입력값에 따라 결과가 다른경우")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void how(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}

