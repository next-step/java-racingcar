package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>(Arrays.asList(1, 1, 2, 3));

    }
    @DisplayName("문자 Size를 확인한다.")
    @Test
    void setSizeTest() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("Set에있는 값과 ValueSource로 받은 값과 비교하여 값을 확인한다.")
    @ParameterizedTest
    @ValueSource(ints  = {1, 2, 3})
    void checkSetValueTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set에있는 값과 CsvSource로 받은 값과 비교하여 값을 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkSetValueTest(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
