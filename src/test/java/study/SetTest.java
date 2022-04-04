package study;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    Set<Integer> set = new HashSet<>();

    @BeforeEach
    void setUp() {
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    @DisplayName("요구사항1 - Set size")
    void setSize() {
        assertThat(set).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("요구사항2 - @ParameterizedTest + @ValueSoucet 활용")
    void parameterizedTest(int input) {
        assertThat(set.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항3 - @ParameterizedTest + @CsvSource 활용")
    void csvSourceTest(int input, boolean expected) {
        assertThat(set.contains(input)).isEqualTo(expected);
    }
}
