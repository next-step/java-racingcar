package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceRecord {
    private static final Random generator = new Random();
    private final int OPPORTUNITY_TO_GO_STRAIGHT;
    private int lap;
    private int myLocation;

    public RaceRecord(int lap, int myLocation, int chanceGoAhead) {
        this.lap = lap;
        this.myLocation = myLocation;
        this.OPPORTUNITY_TO_GO_STRAIGHT = chanceGoAhead;
    }

    private RaceRecord() {
        this.lap = 1;
        this.myLocation = 1;
        this.OPPORTUNITY_TO_GO_STRAIGHT = 10;
    }

    private RaceRecord(int lap, int myLocation) {
        this.lap = lap;
        this.myLocation = myLocation;
        this.OPPORTUNITY_TO_GO_STRAIGHT = 10;
    }

    public static RaceRecord of() {
        return new RaceRecord();
    }

    public int getMyLocation() {
        return myLocation;
    }

    public List<RaceRecord> ofRecordResult(int totalRound) {
        int nowRound = lap;
        int nowMyLocation = myLocation;
        List<RaceRecord> raceRecords = new ArrayList<>(totalRound);
        for (int i = 0; i < totalRound; i++) {
            raceRecords.add(new RaceRecord(nowRound++,
                                           goAhead(nowMyLocation)));
        }
        return raceRecords;
    }

    protected int goAhead(int nowMyLocation) {
        if (4 <= generator.nextInt(OPPORTUNITY_TO_GO_STRAIGHT)) {
            return myLocation++;
        }
        return myLocation;
    }
}
