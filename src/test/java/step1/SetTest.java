package step1;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size test")
    @Test
    public void testSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("value contains test")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testCheckValues(Integer value) {
        assertThat(numbers.contains(value)).isEqualTo(true);
    }

    @DisplayName("false value도 체크 가능한 test")
    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    public void testCheckValues2(String value, String result) {
        Integer actualValue = Integer.parseInt(value);
        Boolean actualResult = Boolean.parseBoolean(result);
        assertEquals(numbers.contains(actualValue), actualResult);
    }
}
