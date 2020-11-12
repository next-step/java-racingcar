package study.racing;

import java.util.LinkedList;

public class RacingRecord {
    private LinkedList<CarSetInRace> carSetInRaces;

    public RacingRecord(LinkedList<CarSetInRace> carSetInRaces) {
        this.carSetInRaces = carSetInRaces;
    }

    public LinkedList<CarSetInRace> getCarSetInRaces(){
        return carSetInRaces;
    }
}

