package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("Set의 크기 확인 테스트")
    void checkSizeTest() {
        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1: true",
            "2: true",
            "3: true",
            "4: false",

    })
    @DisplayName("Set 값 존재 확인 테스트")
    void checkContainsValueTest(int number, boolean isContains) {
        assertThat(numbers.contains(number)).isEqualTo(isContains);
    }
}