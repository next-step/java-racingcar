import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    public void SetTest1_checkSetSize() throws Exception {
        //when
        int size = numbers.size();
        //then
        assertThat(size).isEqualTo(3);
    }

    @ValueSource(ints = { 1, 2, 3})
    @ParameterizedTest
    public void SetTest2_checkIfContainsNumbers(int example) throws Exception {
        //when
        //then
        assertThat(numbers).contains(example);
    }

    @CsvSource(value = { "1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @ParameterizedTest
    public void SetTest3_checkIfContainsNumbers(int example, boolean expectedResult) throws Exception {
        //when

        //then
        assertThat(numbers.contains(example)).isEqualTo(expectedResult);
    }
}
