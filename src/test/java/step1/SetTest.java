package step1;

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
    @DisplayName("Set 사이즈 테스트")
    void setTest1() {
        int sizeOfNumbers = numbers.size();

        assertThat(sizeOfNumbers).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ParameterizedTest 적용 테스트")
    void setTest2(Integer number) {
        assertThat(number).isIn(1, 2, 3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("ParameterizedTest 및 CsvSource 적용 테스트")
    void setTest3(int number, boolean result) {
        assertThat(number < 4).isEqualTo(result);
    }
}
