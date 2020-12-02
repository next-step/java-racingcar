package com.nextstep.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    public void split(){
        String source = "1,2";
        String[] result = source.split(",");

        assertThat(result).containsExactly("1","2");
    }

    @Test
    public void split2(){
        String source = "1";
        String[] result = source.split(",");

        assertThat(result).contains("1");
    }

    @Test
    public void substring(){
        String source = "(1,2)";
        int beginIdx = source.indexOf("(") + 1;
        int endIdx = source.indexOf(")");
        String result = source.substring(beginIdx, endIdx);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 동작 및 예외처리 테스트")
    public void charAt(){
        String source = "abc";
        char result = source.charAt(0);

        assertThat(result).isEqualTo('a');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> source.charAt(3))
                .withMessageMatching("String index out of range: 3");
    }
}
