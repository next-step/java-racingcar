package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;
    private String input = "";
    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    public void size(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    public void contains(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        org.junit.jupiter.api.Assertions.assertTrue(Strings.isBlank(input));

    }

    @ParameterizedTest
    @CsvSource(value = {"1","2","3","4","5"})
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input) {
        boolean actualValue = numbers.contains(Integer.valueOf(input));

        org.assertj.core.api.Assertions.assertThatCode(() -> {
            assertThat(numbers.contains(Integer.valueOf(input))).isTrue();
        });
    }
}
