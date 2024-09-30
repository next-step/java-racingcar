package com.warmup.step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRacingTest {
    
    @Test
    public void isEquals_입력한_숫자만큼_문자열_배열_반환() {
        int expected = 5;

        assertThat(CarRacing.makeStringArray(5)).hasSize(expected);
    }

    @Test
    public void isBetween_0에서_9사이의_랜덤값_반환() {
        int expectedMinNum = 0;
        int expectedMaxNum = 10;

        assertThat(CarRacing.getRandomNumber()).isGreaterThanOrEqualTo(expectedMinNum)
                .isLessThan(expectedMaxNum);
    }

    @Test
    public void isEquals_문자열_뒤에_대쉬_추가() {
        String expected = "--";

        assertThat(CarRacing.addDash("-")).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    public void isEquals_4이상의_숫자는_TRUE_그외의_숫자는_FALSE(int number, boolean expected) {
        assertThat(CarRacing.isForward(number)).isEqualTo(expected);
    }
}
