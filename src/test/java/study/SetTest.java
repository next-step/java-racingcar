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
    @DisplayName("요구사항1 : set 크기 확인")
    void getSize() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("요구사항2 : ParameterizedTest 를 이용해 중복소스 제거")
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"true:false","4:false","5:false"}, delimiter = ':')
    @DisplayName("요구사항3 : CsvSource 를 이용해 false 반환테스트")
    void contains(String input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
        assertThat(numbers.contains(input)).isFalse();
    }
}
