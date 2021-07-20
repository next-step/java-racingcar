package study;

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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
    @Test
    void checkSize(){
        assertThat(numbers.size()).isEqualTo(4);
    }

    @DisplayName("Set에서 특정 값의 존재 여부를 확인 (일반적인 방법)")
    @Test
    void contains1(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("Set에서 특정 값의 존재 여부를 확인 (Parameterized Tests 방법)")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains2(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set에서 특정 값의 존재 여부를 확인 (CsvSource 이용)")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false"})
    void contains3(String input, boolean expected) {
        boolean actualValue = numbers.contains(Integer.parseInt(input));
        assertEquals(expected, actualValue);
    }

    @DisplayName("Set에서 특정 값의 존재 여부를 확인 (CsvSource 이용)")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void contains4(String input, boolean expected) {
        boolean actualValue = numbers.contains(Integer.parseInt(input));
        assertEquals(expected, actualValue);
    }

}
