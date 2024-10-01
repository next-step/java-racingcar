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

    @DisplayName("numbers의 사이즈를 검증한다.")
    @Test
    void test1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("numbers의 저장된 값들을 검증한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test2(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("numbers의 저장된 값들을 각각 검증한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void test3(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
