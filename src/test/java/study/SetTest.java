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
    @DisplayName("set 크기 확인 테스트")
    void check_set_size_test() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "입력값 : {0} {displayName}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("포함 여부 테스트")
    void contains_test(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "입력값 : {0}, 결과값 : {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("값에 따른 결과 반환 테스트")
    void test(int input, boolean expected) {
        assertThat(numbers.contains(input))
                .isEqualTo(expected);
    }
}
