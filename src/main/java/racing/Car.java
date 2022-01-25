package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int MOVE_CHECK_NUMBER = 4;
    private String name;
    private int distance;
    private List<Integer> roundScore;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
        this.roundScore = new ArrayList<>();
    }

    public int getRoundDistance(int roundNumber) {
        return roundScore.get(roundNumber);
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void round() {
        int moveNum = getMoveRandomNumber();
        move(moveNum);
    }

    public void move(int moveNum) {
        if (moveNum >= MOVE_CHECK_NUMBER) {
            distance++;
        }
        roundScore.add(distance);
    }

    public static int getMoveRandomNumber() {
        return (int) ((Math.random() * (10)));
    }
}
