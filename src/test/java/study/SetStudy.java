package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetStudy {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 학습 테스트")
    @Test
    public void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains 학습 테스트")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2, 3
    })
    public void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("contains 입력에 따라 다른 결과 테스트")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    public void contains(int value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }

}
