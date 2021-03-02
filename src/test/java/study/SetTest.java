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

    @Test
    @DisplayName("요구사항 1 : set의 크기 확인")
    void checkSize() {
        assertEquals(3,numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("요구사항 2 : 1,2,3 값이 존재하는지 확인")
    void contains(int number) {
        assertTrue(numbers.contains(number));
    }


    @ParameterizedTest
    @CsvSource({"1,true","2,true","3,true","4,false","5,false"})
    @DisplayName("요구사항 3 : 값이 존재하는지에 따라 true/false를 반환하는지 확인")
    void containsAndReturnValue(String input,String expected){
        assertEquals(expected,numbers.contains(input));
    }

}
