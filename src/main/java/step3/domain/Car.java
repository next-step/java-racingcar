package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int INIT_DISTANCE = 0;
    public static final String NO_ROUND_EXCEPTION_MESSAGE = "해당하는 라운드의 경기기록이 없습니다.";
    public static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 5자를 초과할 수 없습니다.";
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;
    private int distance;
    private List<Round> roundHistory = new ArrayList<>();

    public Car(String name) {
        assertName(name);

        this.name = name;
        this.distance = INIT_DISTANCE;
    }

    private void assertName(String name) {
        if(name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
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

        return roundHistory.stream()
                .filter(round -> round.isRound(roundNumber))
                .map(Round::getDistance)
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalStateException(NO_ROUND_EXCEPTION_MESSAGE);
                });
    }

    public int getDistance() {
        return distance;
    }

    public List<Round> getRoundHistory() {
        return roundHistory;
    }

    public String getName() {
        return name;
    }
}
