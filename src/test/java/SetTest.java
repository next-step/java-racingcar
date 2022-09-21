import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
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
    @DisplayName("Set의 크기를 확인한다.")
    void countSizeOfSet(){
        // WHEN
        int size = numbers.size();

        // THEN
        int expectedSize = 3;
        assertThat(size).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("예상되는 값이 존재하는지 확인한다.")
    void checkIfHasNums(int input){
        // WHEN & THEN
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("여러 값의 존재 유무를 확인한다.")
    void checkIfHasNumsWithCase(int input, boolean expected){
        // WHEN & THEN
        assertThat(numbers.contains(input))
                .isEqualTo(expected);
    }
}
