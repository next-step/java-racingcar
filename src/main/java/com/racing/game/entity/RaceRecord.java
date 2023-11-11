package com.racing.game.entity;

import com.racing.game.dto.Winners;
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

    public Winners winners(){
        return value.get(value.size()-1).winners();
    }

    @Override
    public String toString() {
        return value.stream().map(e -> e.toString().concat("\n")).collect(Collectors.joining()).stripTrailing();
    }
}
