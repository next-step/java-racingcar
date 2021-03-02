package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SetTest {

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
    @DisplayName("요구사항 1 : Set의 크기를 확인한다.")
    void checkSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("요구사항 2 : 중복 코드를 제거해서 1,2,3의 값이 존재하는지 확인해본다.")
    void checkNumExist(int num) {
        assertTrue(numbers.contains(num));
    }

    @ParameterizedTest
    @CsvSource({"1,true","2,true","3,true","4,false","5,false"})
    @DisplayName("요구사항 3 : 중복 코드를 제거해서 1,2,3의 값이 존재하는지 확인하고 결과로 true or false를 반환한다.")
    void checkNumExistAndReturnResult(int num, boolean expected) {
        assertEquals(expected, numbers.contains(num));
    }


}
