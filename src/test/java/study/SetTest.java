package study;

import org.assertj.core.internal.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    void getSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTest(int input){
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1","2","3","4","5"})
    void eachContainsTest(Integer input){
        assertTrue(input + " : " + numbers.contains(input),numbers.contains(input));
    }

}
