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
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    @DisplayName("요구사항1 - Set size를 확인한다.")
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(4);
    }

    @ParameterizedTest(name = "ParameterizedTest를 이용하여 중복코드 제거하기")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2 - contains 메소드 활용하여 값이 존재하는지 여부 판단")
    void containsTest(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest(name = "@CsvSource를 이용하여 number:expected 관계 정의하기")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5: false"}, delimiter = ':')
    void containNumberAndExpected(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
