package com.racing.game.viewmodel;

import com.racing.game.entity.Circuit;
import com.racing.game.entity.RaceEntry;

public class InputViewModel {

    private Circuit circuit;

    public InputViewModel(Circuit circuit) {
        this.circuit = circuit;
    }

    public void readyToRace(RaceEntry raceEntry) {
        circuit.readyToRace(raceEntry);
    }

    public void saveLaps(int lap) {
        circuit.saveLaps(lap);
    }

}
