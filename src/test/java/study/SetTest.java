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

    
    @Test
    @DisplayName("Set의 size() 메소드를 활용해 set의 크기 확인")
    public void compareSetSize() throws Exception {
        //given
        //when
        int size = numbers.size();
        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    @ValueSource(ints = {1,2,3} )
    public void contains(int input) throws Exception {
        //given
        //when
        //then
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("부분적으로 값이 다른 것도 체크")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false","5:false" }, delimiter = ':')
    public void searchPartialValue(String input, String expected) throws Exception {
        //given
        int number = Integer.parseInt(input);
        boolean result = Boolean.parseBoolean(expected);
        //when
        boolean contains = numbers.contains(number);
        //then
        assertThat(contains).isEqualTo(result);
    }




}
