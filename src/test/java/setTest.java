import org.assertj.core.internal.Strings;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.platform.commons.util.StringUtils.isBlank;

public class setTest {

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
    @DisplayName("sizeCheck")
    void size() {
            assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1","2", "3"})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(isBlank(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
        assertTrue(isBlank(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        String actualValue = input.toLowerCase();
        assertEquals(expected, actualValue);
    }

}
