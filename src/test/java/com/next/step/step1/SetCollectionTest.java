package com.next.step.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {

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
    @DisplayName("Set 데이터가 주어지고 size() 메서드를 호출 할 때 크기를 확인하는 테스트")
    void testSetSize() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "Set 데이터와 input 값이 주어지고 input 값을 포함하는지 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void testContainValues(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "Set 데이터와 input, expected 값이 주어지고 input에 따른 expected값이 일치하는지 확인하는 테스트")
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void testIsContainValues(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
