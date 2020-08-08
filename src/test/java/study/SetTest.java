package study;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    /*
     * 1단계 - 학습테스트 실습
     * Set Collection에 대한 학습 테스트
     */
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 요구사항 1
    @Test
    public void size() {
        assertThat(numbers).hasSize(3);
        assertThat(numbers.isEmpty()).isFalse();
    }

    // 요구사항 2
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void containsByValue(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    // 요구사항 3
    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "4:false"}, delimiter=':')  //delimiter -> 구분자
    public void contains(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

}