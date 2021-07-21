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
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    @DisplayName("size를 사용했을 때 set의 크기가 반환되어야 한다.")
    void sizeTet() {

        //when && given
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains를 사용했을 때 set의 value가 존재하면 true가 반횐되어야 한다.")
    void containsTrueTest(int input) {

        //then
        assertTrue(numbers.contains(input));
    }

    @Test
    @DisplayName("contains를 사용했을 때 set의 value가 존재하지 않으면 false가 반환되어야 한다.")
    void containsFalseTest() {

        //when && given
        int input = 10;

        //then
        assertFalse(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("contains를 사용했을 때 set의 value가 존재하면 true가, 존재하지 않으면 false가 반환되어야 한다.")
    void containsTrueAndFalseTest(int input, boolean expected) {

        //then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
