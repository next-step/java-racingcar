import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("setSize test")
    void test1() throws Exception {
        //given
        //when
        int expected = 3;
        int result = numbers.size();
        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("set collection value exist test")
    void test2(String number) throws Exception {
        //given
        //when
        //then
        assertThat(numbers.contains(Integer.valueOf(number))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("set collection value exist test")
    void test3(int input, boolean expected) throws Exception {
        //given
        //when
        //then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
