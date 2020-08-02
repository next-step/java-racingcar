package study;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
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
    void setUP(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void constains(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(4)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,4})
    void contains2(int num){
        assertThat(numbers.contains(num)).isTrue();

    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    void isBlank(String input){
        assertTrue(Stringss.isBlack(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"test:TEST","tEst:TEST","Java:JAVA"},delimiter = ':')
    void toUpperCase(String input,String expected){
        String actualValue = input.toUpperCase();
        assertEquals(expected,actualValue);
    }

    @ParameterizedTest
    @CsvSource(value ={"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    void containsDiffParameter(int input, boolean result){
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}

class Stringss{
    public static  boolean isBlack(String input){
        return input == null || input.trim().isEmpty();
    }
}
