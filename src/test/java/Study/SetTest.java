package Study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

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

    @Test
    @DisplayName("TestSet size")
    void testSetSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }


    @Test
    @DisplayName("TestSet Contains")
    void testContains(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();

    }

    @ParameterizedTest
    @DisplayName("TestSet Contains without dup")
    @ValueSource(ints = {1,2,3})
    void testContainsWithoutDup(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("TestSet Not Contains")
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    void testNotContains(int input , boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }



}
