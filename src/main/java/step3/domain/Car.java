package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int INIT_DISTANCE = 0;
    public static final String NO_ROUND_EXCEPTION_MESSAGE = "해당하는 라운드의 경기기록이 없습니다.";

    private int distance;
    private List<Round> roundHistory = new ArrayList<>();

    public Car() {
        this.distance = INIT_DISTANCE;
    }

    public void move(int roundTime, boolean canMove) {
        if(canMove) {
            this.distance++;
        }

        addRoundHistory(roundTime);
    }

    private void addRoundHistory(int roundTime) {
        roundHistory.add(new Round(roundTime, this.distance));
    }

    public int getDistanceByRound(int roundNumber) {
        for(Round round : roundHistory) {
            if(round.isRound(roundNumber)) {
                return round.getDistance();
            }
        }

        throw new IllegalStateException(NO_ROUND_EXCEPTION_MESSAGE);
    }

    public int getDistance() {
        return distance;
    }

    public List<Round> getRoundHistory() {
        return roundHistory;
    }

}
