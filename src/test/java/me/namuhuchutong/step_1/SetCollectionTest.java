package me.namuhuchutong.step_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("주어진 numbers의 크기는 3이다.")
    @Test
    void given_numbers_size_is_three() {
        //given
        int expected = 3;

        //when
        int result = numbers.size();

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("주어진 numbers는 1,2,3 값이 존재하면 true를 반환")
    @ParameterizedTest(name = "numbers contains {0}")
    @ValueSource(ints = {1, 2, 3})
    void return_true_when_element_contains(int element) {
        //when
        boolean result = numbers.contains(element);

        //then
        assertThat(result).isTrue();
    }
}
