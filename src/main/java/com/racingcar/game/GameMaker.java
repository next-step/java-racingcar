package com.racingcar.game;

public class GameMaker <T> {
    MakeCarsRule makeCarsRule;

    public GameMaker(MakeCarsRule makeCarsRule) {
        this.makeCarsRule = makeCarsRule;
    }

    public Game make(int gameRound, T input) {
        return new Game(gameRound, this.makeCarsRule.makeCar(input));
    }

}
