package com.racingcar.view.model;

public class GameInputDto {
    private String names;
    private int gameRound;

    public GameInputDto(String names, int gameRound) {
        this.names = names;
        this.gameRound = gameRound;
    }

    public String getNames() {
        return names;
    }

    public int getGameRound() {
        return gameRound;
    }
}
