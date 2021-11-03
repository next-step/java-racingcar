package com.kakao.learning;

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
    @DisplayName("size 테스트 : 중복된 숫자를 add시 중복이 제거된다.")
    void sizeTest() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("contains 테스트 : hashSet 내부 value를 포함을 확인한다.")
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int input) {
        boolean result = numbers.contains(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @DisplayName("contains 테스트2 : hashSet 내부 value 포함여부를 확인한다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTest2(String input, String expected) {
        boolean result = numbers.contains(Integer.parseInt(input));
        assertThat(result).isEqualTo(Boolean.parseBoolean(expected));
    }
}
