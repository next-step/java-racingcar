package com.racingcar.dice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class DiceTest {

    @RepeatedTest(100)
    @DisplayName("주사위 값이 10 이하로 나오는지 테스트")
    public void getNumberUnder10() {
        //when
        int value = Dice.getNumber();

        //then
        assertThat(value).isLessThan(10);
    }
}
