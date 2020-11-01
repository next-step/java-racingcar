package study;

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

    @DisplayName("요구사항1-set크기확인")
    @Test
    void setSize(){
        numbers.size();
        assertThat(numbers.size()).isExactlyInstanceOf(Integer.class);
    }

    @DisplayName("요구사항2-cointains")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("요구사항3-cointains")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsCsv(Integer input, Boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
