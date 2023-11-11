package com.racing.game.entity;

import java.util.List;
import java.util.stream.Collectors;

public class RaceRecord {
    private List<RaceEntry> value;

    private RaceRecord(List<RaceEntry> value){
        this.value = value;
    }

    public static RaceRecord from(List<RaceEntry> value){
        return new RaceRecord(value);
    }

    public void progressNextLap(){
        value.add(RaceEntry.from(value.get(value.size()-1).progressCars()));
    }

    public boolean isRaceOver(int lap){
        return value.size() < lap;
    }

    @Override
    public String toString() {
        return value.stream().map(e -> e.toString().concat("\n")).collect(Collectors.joining()).stripTrailing();
    }
}
