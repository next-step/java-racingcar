package edu.nextstep.camp.tutorial;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringTest {
    // 요구사항 1
    private List<Integer> split(String seq) {
        return Arrays.stream(seq.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Test
    void splitTest1() {
        assertEquals(List.of(1, 2), split("1,2"));
    }

    @Test
    void splitTest2() {
        assertEquals(List.of(1), split("1,"));
    }

    // 요구사항 2
    private String substring(String seq) {
        return seq.substring(1, seq.length() - 1);
    }

    @Test
    void substringTest() {
        assertEquals("1,2", substring("(1,2)"));
    }

    // 요구사항 3
    private char charAt(String seq, int index) {
        return seq.charAt(index);
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현")
    void charAtTest() {
        assertEquals('a', charAt("abc", 0));
        assertEquals('b', charAt("abc", 1));
        assertEquals('c', charAt("abc", 2));
        assertThatThrownBy(() -> charAt("abc", 3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}