import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // Test Case 구현
    @Test
    void SetSize() {
        int getSize = numbers.size();
        assertThat(getSize).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1, 2, 3})
    void SetContains(int input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
//    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:false"}, delimiter = ':')
    void CsvSource(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}

