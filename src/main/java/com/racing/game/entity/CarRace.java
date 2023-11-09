package com.racing.game.entity;

import com.racing.game.RaceStorage;
import com.racing.game.utils.CarRandomMove;
import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private final RaceStorage raceStorage;

    public CarRace(RaceStorage storage){
        this.raceStorage = storage;
    }

    public void race() {
        for (int i = 0; i < raceStorage.totalLaps(); i++) {
            raceStorage.saveNextRaceEntry(RaceEntry.from(progressNextLap(i)));
        }
    }


    private List<Car> progressNextLap(int i) {
        return raceStorage.raceStatus(i).lineup().stream().map(element -> {
            if (CarRandomMove.isGoForward()) {
                element.incrementProgress();
            }
            return element;
        }).collect(Collectors.toList());
    }
}
