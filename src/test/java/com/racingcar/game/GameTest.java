package com.racingcar.game;

import com.racingcar.view.model.GameInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @DisplayName("Step3 Game 정상 동작 테스트")
    @ParameterizedTest
    @CsvSource({"5,3", "3,2", "7,6"})
    public void playStep3(String numberOfCars, int gameRound) {
        //given
        GameInput input = new GameInput();
        input.setCarInput(numberOfCars);
        input.setGameRound(gameRound);

        //when
        CarsMakeRule makeCarsRule = new NumberOfCarsMakeMakeRule();
        GameMaker gameMaker = new GameMaker(makeCarsRule);
        Game game = gameMaker.make(input.getGameRound(), input.getCarInput());
        GameResult result = game.play();

        //then
        assertThat(result.getRoundSize()).isEqualTo(gameRound);
    }

    @DisplayName("Step4 Game 정상 동작 테스트")
    @Test
    public void playStep4() {
        //given
        int gameRound = 5;
        String names = "test,name,rock";

        GameInput input = new GameInput();
        input.setCarInput(names);
        input.setGameRound(gameRound);

        //when
        CarsMakeRule makeCarsRule = new NamedCarsMakeRule();
        GameMaker gameMaker = new GameMaker(makeCarsRule);
        Game game = gameMaker.make(input.getGameRound(), input.getCarInput());
        GameResult result = game.play();

        //then
        assertThat(result.getRoundSize()).isEqualTo(gameRound);
    }
}
