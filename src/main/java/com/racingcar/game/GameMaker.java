package com.racingcar.game;

public class GameMaker {
    MakeCarsRule makeCarsRule;

    public GameMaker(MakeCarsRule makeCarsRule) {
        this.makeCarsRule = makeCarsRule;
    }

    public Game make(int gameRound, String input) {
        return new Game(gameRound, this.makeCarsRule.makeCar(input));
    }

}
