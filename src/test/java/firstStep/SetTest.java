package firstStep;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void sizeTest(){
        //given
        //when
        numbers.add(4);
        //then
        assertThat(numbers.size()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTest(int number){
        //given
        //when
        //then
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:fasle", "5:false"}, delimiter = ':')
    void containsTestWithCsv(String input, String expected ){

        int actual = Integer.parseInt(input);
        boolean result = Boolean.parseBoolean(expected);
        assertThat(numbers.contains(actual)).isEqualTo(result);
    }

}
