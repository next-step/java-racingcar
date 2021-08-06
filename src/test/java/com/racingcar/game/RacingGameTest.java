package com.racingcar.game;

import com.racingcar.view.model.GameInputDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @DisplayName("RacingGame 정상 동작 테스트")
    @Test
    public void play() {
        //given
        String names = "john,cart,mon,see";
        int gameRound = 5;
        GameInputDto input = new GameInputDto(names, gameRound);

        //when
        RacingGame racingGame = GameMaker.make(input);

        //then
        racingGame.play();
    }
}
