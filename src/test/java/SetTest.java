import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp () {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 사이즈 체크")
    void checkSetSize () {
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set 값 존재 확인")
    @ValueSource(ints = {1, 2, 3})
    void contains (int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set 값 존재 확인하여 있으면 true / 없으면 false")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void isContains(int number, boolean result) {
        boolean isContains = numbers.contains(number);
        assertEquals(isContains, result);
    }

}
