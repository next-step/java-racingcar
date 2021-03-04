package step_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Set Collection Edu Test")
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
    @DisplayName("Set Size Test")
    @Test
    void sizeAssertion() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @DisplayName("ParameterizedTest Annotation Test")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int sourceValue) {
        assertThat(numbers.contains(sourceValue))
                .isTrue();
    }

    @DisplayName("Execute Expected Planing Test")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void how(int sourceValue, boolean expected) {
        assertThat(numbers.contains(sourceValue))
                .isEqualTo(expected);
    }
}
