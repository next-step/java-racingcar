package com.cheolhyeonpark.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiceTest {

    Dice dice = new Dice();

    @Test
    @DisplayName("주사위를 굴리면 0 ~ 9 까지 숫자가 반환된다")
    public void returnNumberAfterRollDice() {
        //given
        int diceNumber;

        //when
        diceNumber = dice.rollDice();

        //then
        assertThat(diceNumber).isBetween(0, 9);
    }
}