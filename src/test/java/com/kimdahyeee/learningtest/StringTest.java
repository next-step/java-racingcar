package com.kimdahyeee.learningtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    void splitByComma() {
        String[] result = "1,2".split(",");
        assertEquals(2, result.length);
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    void splitOneByComma() {
        String[] result = "1".split(",");
        assertEquals(1, result.length);
        assertThat(result).containsExactly("1");
    }

    @DisplayName("특정 값이 주어졌을 때 charAt()메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    @ParameterizedTest
    @ValueSource(strings = "abc")
    void charAt(String value) {
        assertEquals('a', value.charAt(0));
        assertEquals('b', value.charAt(1));
        assertEquals('c', value.charAt(2));

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            value.charAt(value.length());
        });
    }

}
