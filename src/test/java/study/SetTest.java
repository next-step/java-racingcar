package study;

import org.assertj.core.api.AbstractBooleanAssert;
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
    @DisplayName("size 메소드 학습 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "contains 메소드 학습 테스트 - 결과값이 같은 경우")
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "contains 메소드 학습 테스트 - 결과값이 다른 경우 포함")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_false_case(String input, String expected) {
        assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(Boolean.valueOf(expected));
    }
}
