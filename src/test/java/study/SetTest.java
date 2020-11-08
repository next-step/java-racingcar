package calcurator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
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

    @DisplayName("Require01 SetSize Check")
    @Test
    void setSizeTest() {
        int expectSetSize = 3;
        assertThat(expectSetSize).isEqualTo(numbers.size());
    }

    @DisplayName("Require01 invalid SetSize Check")
    @Test
    void invalidSetSizeTest() {
        int expectSetSize = numbers.size() + 1;
        assertThat(expectSetSize).isNotEqualTo(numbers.size());
    }

    @DisplayName("Require02 Contain Test")
    @Test
    void containTest() {
        assertAll(
                () -> assertThat(numbers.contains(1)).isTrue(),
                () -> assertThat(numbers.contains(2)).isTrue(),
                () -> assertThat(numbers.contains(3)).isTrue()
        );
    }

    @DisplayName("Require02 Contain Parameterized Test")
    @ParameterizedTest
    @ValueSource(ints = {1, 1, 2})
    void containParameterizedTest(int element) {
        assertTrue(numbers.contains(element));
    }

    @DisplayName("Require03 Contain Method Test")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containMethodTest(int input, String expect) {
        assertThat(numbers.contains(input)).isEqualTo(Boolean.parseBoolean(expect));
    }


}
