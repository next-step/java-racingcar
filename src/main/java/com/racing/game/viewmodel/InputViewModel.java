package com.racing.game.viewmodel;

import com.racing.game.RaceStorage;
import com.racing.game.entity.RaceEntry;

public class InputViewModel {

    private RaceStorage raceStorage;

    public InputViewModel(RaceStorage raceStorage) {
        this.raceStorage = raceStorage;
    }

    public void saveCar(RaceEntry raceEntry){
        raceStorage.saveNextRaceEntry(raceEntry);
    }

    public void saveLaps(int lap) {
        raceStorage.saveLaps(lap);
    }

}
