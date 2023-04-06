package study;

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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 size 확인하는 메소드")
    public void getSetSize() {
        assertEquals(3, numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ParameterizedTest 활용")
    public void contains(int iNums) {
        assertThat(numbers.contains(iNums)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("CsvSource 활용")
    void checkNumber(int iNum, boolean expected) {
        assertThat(numbers.contains(iNum)).isEqualTo(expected);
        assertEquals(numbers.contains(iNum), expected);
    }
}
