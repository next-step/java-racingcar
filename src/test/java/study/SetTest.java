package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("Set의 Size() 메소드를 활용해 크기를 확인하는 학습테스트를 구현한다.")
    void setSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Set 안에 포함된 요소들 확인하기 : 단순")
    void containsV1() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set 안에 포함된 요소들 확인하기 : @ParameterizedTest ")
    @ValueSource(ints = {1, 2, 3})
    void containsV2(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set 안에 포함된 요소들 확인하기 : @CsvSource ")
    @CsvSource(value = {"1:true", "2:true", "3:true"}, delimiter = ':')
    void containsV3(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }


}
