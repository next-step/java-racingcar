package com.hskim.nextstep.step02.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
    com.hskim.nextstep.step02 - StringUtils class 테스트
 */
public class StringUtilsTest {

    @DisplayName("받은 문자열이 Numeric인지 판단하는 isNumeric() 메소드 검증")
    @ParameterizedTest
    @CsvSource(value = {"5:true", "2.0:true", "125:true", "-4:true", "a:false", "%:false", ";:false"}, delimiter = ':')
    void isNumericTest(String input, boolean expected) {

        assertThat(StringUtils.isNumeric(input)).isEqualTo(expected);
    }

    @DisplayName("문자열과 횟수를 받아 횟수만큼 반복한 문자열을 돌려주는 repeat() 메소드 검증")
    @ParameterizedTest
    @CsvSource(value = {"*,3:***", "&!,2:&!&!", "abc,1:abc", "d,5:ddddd"}, delimiter = ':')
    void repeatTest(String args, String expected) {

        String[] argArr = args.split(",");
        String with = argArr[0];
        int count = Integer.valueOf(argArr[1]);
        assertThat(StringUtils.repeat(with, count)).isEqualTo(expected);
    }

    @DisplayName("문자열과 구분자를 받아 문자열 리스트를 반환하는 getParsedStringList() 메소드 검증")
    @Test
    void getParsedStringListTest() {

        String origin = "test1,test2,test3";
        String delimiter = ",";
        List<String> expected = new LinkedList<>(Arrays.asList("test1", "test2", "test3"));

        assertThat(StringUtils.getParsedStringList(origin, delimiter)).isEqualTo(expected);
    }
}
