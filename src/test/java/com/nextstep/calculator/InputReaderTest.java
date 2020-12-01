package com.nextstep.calculator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputReaderTest {
    @Test
    public void readString(){
        String source = "abc";
        InputReader inputReader = new InputReader(new ByteArrayInputStream(source.getBytes()));
        String result = inputReader.readString();

        assertThat(result).isEqualTo("abc");
    }
}
