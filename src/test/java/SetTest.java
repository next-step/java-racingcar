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
    @DisplayName("요구사항1")
    public void 요구사항1() {
        //given
        int setSize = numbers.size();
        int expectedSize = 3;
        //when
        assertThat(setSize).isEqualTo(expectedSize);
        //then
    }


    @DisplayName("요구사항2")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3})
    public void 요구사항2(int input) {
        //given
        assertThat(numbers.contains(input)).isTrue();
        //when

        //then
    }

    @ParameterizedTest
    @DisplayName("요구사항3")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void 요구사항3(String input, boolean expected) {
        //given
        assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(expected);
        //when

        //then
    }
}
