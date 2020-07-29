package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    // 파라미터를 주어서 테스트
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "4:false"}, delimiter = ':')
    void csvContains(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

    // Test Case 구현
    @Test
    public void size() {
        assertThat(numbers).hasSize(3); //사이즈를 assertThat
        assertThat(numbers.isEmpty()).isFalse();
    }
}