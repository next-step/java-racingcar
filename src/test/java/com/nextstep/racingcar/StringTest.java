package com.nextstep.racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
