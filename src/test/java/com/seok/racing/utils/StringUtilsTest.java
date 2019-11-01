package com.seok.racing.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.seok.racing.domain.Movable;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {


    static Stream<Arguments> strings() {

        return Stream.of(
            Arguments.of("-", 5, "-----"),
            Arguments.of("*", 3, "***")
        );
    }

    @ParameterizedTest
    @MethodSource("strings")
    void repeat(String string, int count, String expected) {
        assertThat(StringUtils.repeat(string,count)).isEqualTo(expected);
    }

    @Test
    void split() {
        assertThat(StringUtils.split("1,2,3,4")).containsOnly("1","2","3","4");
        assertThat(StringUtils.split("1/2/3/4","/")).containsOnly("1","2","3","4");
    }
}