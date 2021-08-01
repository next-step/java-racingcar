package com.racingcar.game;

public class GameMaker {
    CarsMakeRule makeCarsRule;

    public GameMaker(CarsMakeRule makeCarsRule) {
        this.makeCarsRule = makeCarsRule;
    }

    public Game make(int gameRound, String input) {
        return new Game(gameRound, this.makeCarsRule.makeCar(input));
    }

}
