package com.racing.game;

import com.racing.game.entity.RaceEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceStorage {
    private List<RaceEntry> raceRecord;
    private int lap;

    public RaceStorage() {
        this.raceRecord = new ArrayList<>();
        this.lap = 0;
    }

    public RaceEntry lapToReport(int lap) {
        return raceRecord.get(lap);
    }

    public void saveNextRaceEntry(RaceEntry raceEntry) {
        raceRecord.add(raceEntry);
    }

    public void saveLaps(int laps) {
        this.lap = laps;
    }

    public int totalLaps() {
        return lap;
    }

    public int carCount() {
        return raceRecord.get(0).carCount();
    }

    public RaceEntry raceStatus(int lap) {
        return raceRecord.get(lap);
    }

    @Override
    public String toString() {
        return raceRecord.stream().map(e -> e.toString().concat("\n")).collect(Collectors.joining());
    }
}
