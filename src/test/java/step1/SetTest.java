package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest
{
    private Set<Integer> numbers;

    @BeforeEach
    void setUp()
    {
        numbers =new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("set의 크기를 확인한다.")
    void sizeTest()
    {
        //given
        int size = numbers.size();
        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("set의 1, 2, 3이 포함되는지 확인한다.")
    void containsTest(int number)
    {
        //then
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false", "5:false"}, delimiter = ':')
    @DisplayName("set의 특정 숫자가 포함되는지 포함이 되지 않는지 확인한다.")
    void containsCompareTest(int number, boolean isContains)
    {
        //then
        assertThat(numbers.contains(number)).isEqualTo(isContains);
    }
}
