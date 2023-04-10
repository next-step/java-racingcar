package com.nextstep.racingcar.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    @DisplayName("Set 중복값이 제거된 사이즈를 반환 한다")
    void setSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("contains 1, 2, 3 값을 포함한다")
    void containsHardCodedTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest(name = "[{index}] {0} 는 Set 함수에 포함한다")
    @ValueSource(ints = {1, 2, 3})
    void containsTestWithTrueCases(int valueSource) {
        assertThat(numbers.contains(valueSource)).isTrue();
    }

    @ParameterizedTest(name = "[{index}] {0} 는 Set 함수에 포함된다 : {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void containsTestWithAllCases(int valueSource, boolean expected) {
        assertThat(numbers.contains(valueSource)).isEqualTo(expected);
    }
}
