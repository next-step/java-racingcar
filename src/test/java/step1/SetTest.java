package step1;

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
    @DisplayName("Set의 크기를 확인하는 테스트")
    void getSize() {
        int size = numbers.size();
        assertEquals(3, size);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("1,2,3의 값이 존재하는지를 확인하는 학습테스트")
    void contains(int input) {
        assertThat((numbers).contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,True", "2,True", "3,True", "4,False", "5,False"})
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    void contains2(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
    }

}
