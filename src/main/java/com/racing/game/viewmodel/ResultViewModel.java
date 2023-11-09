package com.racing.game.viewmodel;

import com.racing.game.RaceStorage;

public class ResultViewModel {

    private final RaceStorage raceStorage;

    public ResultViewModel(RaceStorage raceStorage){
        this.raceStorage = raceStorage;
    }

    public String allResultString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < raceStorage.totalLaps(); i++) {
            builder.append(raceStorage.raceStatus(i));
        }
        return builder.toString();
    }

    private String resultString(int lap) {
        return raceStorage.raceStatus(lap).toString();
    }
}
