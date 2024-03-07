package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("요구사항 1")
    public void size(){
        int setSize = numbers.size();
        Assertions.assertThat(setSize).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("요구사항 2")
    @ValueSource(ints = {1, 2, 3})
    public void contains(int existedNumber){
        Assertions.assertThat(numbers.contains(existedNumber)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("요구사항 3")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void contains_tf(int expectedNumber, boolean tf){
        Assertions.assertThat(numbers.contains(expectedNumber)).isEqualTo(tf);
    }
}
