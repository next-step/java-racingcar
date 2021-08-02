package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>(Arrays.asList(1, 1, 2, 3));
    }


    @Test
    @DisplayName("Set크기확인")
    void setSizeCheck() {
        Assertions.assertEquals(3, numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("SetContains확인")
    void SetContainsCheck(Integer input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @DisplayName("ParameterizedTest를 이용해 셋요소 비교")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void compareSetElementAndParameter(String input, String expected) {

        assertEquals(numbers.contains(Integer.parseInt(input)), Boolean.parseBoolean(expected));

    }

}
