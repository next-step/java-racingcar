package com.racing.game.viewmodel;

import com.racing.game.dto.RaceResult;

public class ResultViewModel {
    private RaceResult raceResult;

    public void saveRaceResult(RaceResult raceResult) {
        this.raceResult = raceResult;
    }

    public RaceResult raceResult() {
        return raceResult;
    }
}
