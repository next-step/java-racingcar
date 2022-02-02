package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private static final int MOVE_CHECK_NUMBER = 4;
    private static final int INITIAL_DISTANCE = 0;
    private final static int NAME_LENGTH_LIMIT = 5;

    private String name;
    private List<Integer> roundScore;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.roundScore = new ArrayList<>(Arrays.asList(INITIAL_DISTANCE));
    }

    public int getRoundDistance(int roundNumber) {
        return roundScore.get(roundNumber);
    }

    public int getDistance() {
        return roundScore.get(roundScore.size() - 1);
    }

    public String getName() {
        return name;
    }

    public void move(int moveNum) {
        int nowDistance = getDistance();
        if (moveNum >= MOVE_CHECK_NUMBER) {
            nowDistance++;
        }
        roundScore.add(nowDistance);
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

}
