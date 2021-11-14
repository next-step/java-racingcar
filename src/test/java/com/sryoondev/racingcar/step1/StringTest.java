package com.sryoondev.racingcar.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    void testSplit() {
        String str1 = "1,2";
        String[] split1 = str1.split(",");
        assertThat(split1).contains("1", "2");

        String str2 = "1";
        String[] split2 = str2.split(",");
        assertThat(split2).containsExactly("1");
    }

    @Test
    void testSubstring() {
        String str = "(1,2)";
        String substring = str.substring(1, str.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스의 chatAt 메소드 테스트. 배열의 범위를 벗어나면 StringIndexOutOfBoundsException 발생.")
    void testCharAt() {
        String str = "abc";
        char c = str.charAt(1);
        assertThat(c).isEqualTo('b');

        assertThatThrownBy(() -> str.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
