package com.kimdahyeee.racing;

import com.kimdahyeee.racing.rule.MovableStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    @Test
    @DisplayName("자동차 레이싱 게임 우승자 구하기 (우승자는 여러명일 수 있다.)")
    void getRacingWinners() {
        MovableStrategy movableStrategy = () -> true;
        RacingGame racingGame = new RacingGame(1, Arrays.asList("1", "2", "3"), movableStrategy);

        racingGame.move();

        assertEquals(3, racingGame.getWinners().size());

    }

}