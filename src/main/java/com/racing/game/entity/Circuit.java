package com.racing.game.entity;

import com.racing.game.dto.Winners;
import java.util.ArrayList;
import java.util.List;

public class Circuit {
    private RaceRecord raceRecord;
    private int lap;

    public Circuit() {
        this.raceRecord = RaceRecord.from(new ArrayList<>());
        this.lap = 0;
    }

    public void readyToRace(RaceEntry raceEntry) {
        raceRecord = RaceRecord.from(new ArrayList<>(List.of(raceEntry)));
    }

    public void startRace() {
        while (raceRecord.isRaceOver(lap)) {
            raceRecord.progressNextLap();
        }
    }


    public void saveLaps(int laps) {
        this.lap = laps;
    }

    public int totalLaps() {
        return lap;
    }

    public Winners winners() {
        return raceRecord.winners();
    }

    @Override
    public String toString() {
        return raceRecord.toString();
    }
}
